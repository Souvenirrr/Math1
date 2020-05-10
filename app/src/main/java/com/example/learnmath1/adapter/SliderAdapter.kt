package com.example.learnmath1.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.learnmath1.fragment.QuestionFragment

private const val NUM_PAGES = 10

class SliderAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getCount(): Int = NUM_PAGES

    override fun getItem(position: Int): Fragment = QuestionFragment()
}