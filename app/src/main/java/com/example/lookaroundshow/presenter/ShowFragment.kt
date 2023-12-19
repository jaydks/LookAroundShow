package com.example.lookaroundshow.presenter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lookaroundshow.R
import com.example.lookaroundshow.data.Show
import com.example.lookaroundshow.databinding.FragmentShowBinding
import com.example.lookaroundshow.helper.ShowAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShowFragment : Fragment() {
    private lateinit var binding: FragmentShowBinding
    private lateinit var adapter: ShowAdapter
    private var showList = ArrayList<Show>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //readShow()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_show, container, false)

        //initRecyclerView()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        // 코루틴 스코프에서 데이터 파싱 실행
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                readShow()
            }
            initRecyclerView()
        }
    }

    private fun initRecyclerView() {
        adapter = ShowAdapter(requireContext(), showList)
        binding.rvShow.layoutManager = LinearLayoutManager(requireContext())
        binding.rvShow.adapter = adapter
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

    private fun writeShow() {
        val database = Firebase.database
        val myRef = database.getReference("second")

        val show = Show(
            1,
            "해설이 있는 무용_Nude，누드－부산",
            "부산",
            "부산문화회과 중극장",
            "70분",
            "2023.12.27",
            "2023.12.27",
            "https://github.com/jaydks/LookAroundShow/assets/106398273/a237485d-7cf0-4a89-a0b0-7d509fc66b76",
            "예매가능시간: 전일17시(월~토 관람 시)까지/전일 11시(일요일 관람 시)까지\n" +
                    "\n" +
                    "2023년 12월 27일 (수) 19:30",
            "https://github.com/jaydks/LookAroundShow/assets/106398273/a237485d-7cf0-4a89-a0b0-7d509fc66b76",
            "false",
            "https://tickets.interpark.com/goods/23018336?app_tapbar_state=hide&"
        )

        myRef.child("8").setValue(show)
    }



}