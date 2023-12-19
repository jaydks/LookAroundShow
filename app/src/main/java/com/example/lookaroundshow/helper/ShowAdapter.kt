package com.example.lookaroundshow.helper

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lookaroundshow.R
import com.example.lookaroundshow.data.Show
import com.example.lookaroundshow.databinding.ItemShowBinding
import com.example.lookaroundshow.presenter.ShowDetailActivity
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ShowAdapter(private val context: Context, private val showList: ArrayList<Show>): RecyclerView.Adapter<ShowAdapter.CustomViewHolder>() {
    inner class CustomViewHolder(private val binding:ItemShowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(show: Show) {
            with(binding) {
                tvShowTitle.text = show.title
                tvShowDate.text = show.startDate + " ~ " + show.endDate
                tvShowHall.text = show.hall
                Glide.with(context)
                    .load(show.poster)
                    .into(ivShow)
                cbShowHeart.isChecked = show.isLiked == "true"
            }
        }
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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int = showList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(showList[position])

        holder.itemView.setOnClickListener {
            Log.d("test", "test")
            val intent = Intent(context, ShowDetailActivity::class.java)
            intent.putExtra("showId", showList.get(position).id)
            context.startActivity(intent)
        }
    }
}