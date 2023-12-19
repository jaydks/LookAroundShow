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