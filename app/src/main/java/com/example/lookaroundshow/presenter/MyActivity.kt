package com.example.lookaroundshow.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lookaroundshow.data.Show
import com.example.lookaroundshow.databinding.ActivityMyBinding
import com.example.lookaroundshow.helper.ShowAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyBinding
    private lateinit var adapter: ShowAdapter
    private var showList = ArrayList<Show>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        readShow()
        initClickListener()
    }

    private fun readShow() {
        val database = Firebase.database
        val myRef = database.getReference("second")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                showList.clear()
                for (data in snapshot.children) {
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

    private fun initClickListener() {
        binding.ivMyBack.setOnClickListener {
            finish()
        }
        binding.tvMyLikedShow.setOnClickListener{
            initRecyclerView()
        }
    }

    private fun initRecyclerView() {
        var likedList = ArrayList<Show>()

        likedList = showList.filter {
            it.isLiked.toString() == "true"
        } as ArrayList<Show>


        adapter = ShowAdapter(this, likedList)
        binding.rvLikedShow.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvLikedShow.adapter = adapter
    }
}