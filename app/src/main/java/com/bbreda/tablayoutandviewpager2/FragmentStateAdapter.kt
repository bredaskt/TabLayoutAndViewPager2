package com.bbreda.tablayoutandviewpager2

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(@NonNull fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    @NonNull
    override fun createFragment(position: Int): Fragment {
        return CardFragment.newInstance(position)
    }

    override fun getItemCount(): Int {
        return CARD_ITEM_SIZE
    }

    companion object {
        private val CARD_ITEM_SIZE = 10
    }
}
