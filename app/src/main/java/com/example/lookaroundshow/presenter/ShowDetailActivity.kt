package com.example.lookaroundshow.presenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.lookaroundshow.BookActivity
import com.example.lookaroundshow.R
import com.example.lookaroundshow.data.Show
import com.example.lookaroundshow.databinding.ActivityMyBinding
import com.example.lookaroundshow.databinding.ActivityShowDetailBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ShowDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowDetailBinding
    private var title = ""
    private var poster = ""
    private var hall = ""
    private var duration = ""
    private var date = ""
    private var description = ""
    private var bookLink = ""
    private var isLiked = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowDetailBinding.inflate(layoutInflater)
        title = intent.getStringExtra("title").toString()
        poster = intent.getStringExtra("poster").toString()
        hall = intent.getStringExtra("hall").toString()
        duration = intent.getStringExtra("duration").toString()
        date = intent.getStringExtra("date").toString()
        description = intent.getStringExtra("description").toString()
        bookLink = intent.getStringExtra("bookLink").toString()
        isLiked = intent.getStringExtra("isLiked").toString()

        initClickListener()
        setView()

        setContentView(binding.root)
    }

    private fun initClickListener() {
        binding.ivMyBack.setOnClickListener {
            finish()
        }
        binding.tvDetailBook.setOnClickListener{
            val intent = Intent(this, BookActivity::class.java)
            intent.putExtra("bookLink", bookLink)
            startActivity(intent)
        }
    }

    private fun setView() {
        binding.cbDetailHeart.isChecked = isLiked == "true"
        Glide.with(this)
            .load(poster)
            .into(binding.ivDetailPoster)
        binding.tvDetailTitle.text = title
        binding.tvDetailDate.text = date
        binding.tvShowDuration.text = "공연시간 : " + duration
        binding.tvDetailHall.text = hall
        binding.tvDescription.text = description
    }

}