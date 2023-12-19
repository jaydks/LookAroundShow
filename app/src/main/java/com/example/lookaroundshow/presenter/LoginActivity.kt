package com.example.lookaroundshow.presenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lookaroundshow.R
import com.example.lookaroundshow.data.Show
import com.example.lookaroundshow.databinding.ActivityLoginBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var showList = ArrayList<Show>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_LookAroundShow)
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
    }

    private fun initLayout() {
        binding.ivLoginKakao.setOnClickListener{
            // todo : 카카오 로그인
        }

        binding.tvLoginLookAround.setOnClickListener {
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
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
}

