package com.example.lookaroundshow.presenter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lookaroundshow.R
import com.example.lookaroundshow.data.Show
import com.example.lookaroundshow.databinding.FragmentCalendarBinding
import com.example.lookaroundshow.databinding.FragmentShowBinding
import com.example.lookaroundshow.helper.ShowAdapter

class CalendarFragment : Fragment() {
    private lateinit var binding: FragmentCalendarBinding
    private lateinit var adapter: ShowAdapter
    private var showList = ArrayList<Show>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calendar, container, false)

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        setShowList()
        adapter = ShowAdapter(requireContext(), showList)
        binding.rvTodayShow.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvTodayShow.adapter = adapter
    }

    private fun setShowList() {
        showList = arrayListOf(
            Show(
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                true,
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                true,
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                true,
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                true,
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                true,
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                true,
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                true,
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                true,
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            ),
            Show(
                "뮤지컬 <레미제라블>",
                "서울",
                "블루스퀘어 신한카드홀",
                "180분",
                "2023.11.30",
                "2024.03.10",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                "예매가능시간: 관람 3시간 전까지",
                "https://github.com/jaydks/LookAroundShow/assets/106398273/f1d35e53-8589-4531-a3f0-e1fac517f15b",
                true,
                "https://tickets.interpark.com/goods/23012526?GoodsCode=23012526"
            )
        )
    }
}