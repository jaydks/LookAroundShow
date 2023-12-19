package com.example.lookaroundshow.helper

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lookaroundshow.presenter.CalendarFragment
import com.example.lookaroundshow.presenter.ShowFragment

class ViewpagerFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    val fragmentList = listOf<Fragment>(ShowFragment(), CalendarFragment())
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

}