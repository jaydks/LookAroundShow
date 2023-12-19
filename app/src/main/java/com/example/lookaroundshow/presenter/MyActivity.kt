package com.example.lookaroundshow.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lookaroundshow.data.Show
import com.example.lookaroundshow.databinding.ActivityMyBinding
import com.example.lookaroundshow.helper.ShowAdapter

class MyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyBinding
    private lateinit var adapter: ShowAdapter
    private var showList = ArrayList<Show>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initClickListener()
    }

    private fun initClickListener() {
        binding.ivMyBack.setOnClickListener{
            finish()
        }
    }

    private fun initRecyclerView() {
        setShowList()
        adapter = ShowAdapter(this, showList)
        binding.rvLikedShow.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvLikedShow.adapter = adapter
    }

    private fun setShowList() {
        showList = arrayListOf(
            Show(
                1,
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "true",
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                1,
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "true",
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                1,
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "true",
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                1,
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "true",
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                1,
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "true",
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                1,
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "true",
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                1,
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "true",
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                1,
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "true",
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                1,
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "true",
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                1,
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "true",
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
        )
    }}