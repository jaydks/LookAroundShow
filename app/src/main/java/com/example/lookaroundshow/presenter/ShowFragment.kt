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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_show, container, false)
        initSetOnClickListener()

        return binding.root
    }

    private fun initSetOnClickListener() {
        binding.ivSearch.setOnClickListener{
            val searchText = binding.etShowRegion.text
            var searchShowList = ArrayList<Show>()

            searchShowList = showList.filter {
                it.region == searchText.toString()
            } as ArrayList<Show>

            initRecyclerView(searchShowList)
        }

    }

    override fun onResume() {
        super.onResume()
        // 코루틴 스코프에서 데이터 파싱 실행
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                readShow()
            }
            withContext(Dispatchers.Main) {
                initRecyclerView(showList)

            }
        }
    }

    private fun initRecyclerView(list: java.util.ArrayList<Show>) {
        adapter = ShowAdapter(requireContext(), list)
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
}