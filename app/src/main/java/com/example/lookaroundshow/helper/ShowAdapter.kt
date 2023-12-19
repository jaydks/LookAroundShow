package com.example.lookaroundshow.helper

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lookaroundshow.R
import com.example.lookaroundshow.data.Show
import com.example.lookaroundshow.databinding.ItemShowBinding

class ShowAdapter(private val context: Context, private val showList: ArrayList<Show>): RecyclerView.Adapter<ShowAdapter.CustomViewHolder>() {
    inner class CustomViewHolder(private val binding:ItemShowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(show: Show) {
            with(binding) {
                tvShowTitle.text = show.title
                tvShowDate.text = show.startDate + " ~ " + show.endDate
                tvShowHall.text = show.hall
                Glide.with(context)
                    .load("https://github-production-user-asset-6210df.s3.amazonaws.com/106398273/291582461-f1d35e53-8589-4531-a3f0-e1fac517f15b.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20231219%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20231219T123113Z&X-Amz-Expires=300&X-Amz-Signature=f4d1df343b8582e0377c3792f9d7eb70b1141262a80d4639a6f6edf7ae13eddd&X-Amz-SignedHeaders=host&actor_id=106398273&key_id=0&repo_id=733407939")
                    .into(ivShow)
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
    }
}