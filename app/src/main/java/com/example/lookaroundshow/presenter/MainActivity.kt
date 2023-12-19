package com.example.lookaroundshow.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lookaroundshow.R
import com.example.lookaroundshow.databinding.ActivityMainBinding
import com.example.lookaroundshow.helper.ViewpagerFragmentAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewpagerFragmentAdapter: ViewpagerFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewPager()
    }

    private fun setViewPager() {
        val tabTitles = listOf<String>("공연", "캘린더")
        viewpagerFragmentAdapter = ViewpagerFragmentAdapter(this)
        binding.viewPager.adapter = viewpagerFragmentAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
            when (position) {
                0 -> tab.setIcon(R.drawable.img_tab_first)
                1 -> tab.setIcon(R.drawable.img_tab_second)
            }}.attach()
    }
}