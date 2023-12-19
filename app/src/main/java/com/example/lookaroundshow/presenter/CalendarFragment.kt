package com.example.lookaroundshow.presenter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lookaroundshow.R
import com.example.lookaroundshow.data.Show
import com.example.lookaroundshow.databinding.FragmentCalendarBinding
import com.example.lookaroundshow.helper.ShowAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class CalendarFragment : Fragment(), OnClickListener {
    private lateinit var binding: FragmentCalendarBinding
    private lateinit var adapter: ShowAdapter
    private var showList = ArrayList<Show>()
    private var todayShowList = ArrayList<Show>()
    private var date = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calendar, container, false)

        readShow()
        initSetOnClickListener()
        getCalendar()
        return binding.root
    }

    private fun getCalendar() {
        binding.calendar.setOnDateChangeListener(object: CalendarView.OnDateChangeListener{
            override fun onSelectedDayChange(
                view: CalendarView,
                year: Int,
                month: Int,
                dayOfMonth: Int
            ) {
                date = "$year.${month+1}.$dayOfMonth"
                Log.d("date", date)
                showTodayShow()
            }
        })
    }

    private fun initSetOnClickListener() {
        binding.tvCalendarMy.setOnClickListener(this)
    }

    private fun showTodayShow() {
        todayShowList = ArrayList<Show>()
        var todayDate = date.replace(".","").toInt()

        todayShowList = showList.filter {
            (( it.startDate.replace(".", "").toInt() <= todayDate ) && (todayDate <= it.endDate.replace(".", "").toInt()))
        } as ArrayList<Show>
        binding.tvCalendarTodayShow.text = "$date 에 하는 공연이에요! ${(todayShowList.size)}"

        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = ShowAdapter(requireContext(), todayShowList)
        binding.rvTodayShow.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvTodayShow.adapter = adapter
    }

    private fun readShow() {
        val database = Firebase.database
        val myRef = database.getReference("second")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                showList.clear()
                for(data in snapshot.children) {
                    Log.d("test", data.child("title").value.toString())
                    val show = Show(
                        1,
                        data.child("title").value.toString(),
                        data.child("region").value.toString(),
                        data.child("hall").value.toString(),
                        data.child("duration").value.toString(),
                        data.child("startDate").value.toString(),
                        data.child("endDate").value.toString(),
                        data.child("poster").value.toString(),
                        data.child("descriptionString").value.toString(),
                        data.child("descriptionImage").value.toString(),
                        data.child("liked").value.toString(),
                        data.child("bookLink").value.toString()
                    )
                    showList.add(show)
                }
            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_calendar_my -> {
                val intent = Intent(requireContext(), MyActivity::class.java)
                startActivity(intent)
            }
        }

    }
}