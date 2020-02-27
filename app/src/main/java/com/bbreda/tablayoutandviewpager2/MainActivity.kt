package com.bbreda.tablayoutandviewpager2

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_pager.adapter = createCardAdapter()
        TabLayoutMediator(tabs, view_pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = "Tab " + (position + 1)
            }).attach()
    }
    private fun createCardAdapter(): ViewPagerAdapter {
        return ViewPagerAdapter(this)
    }
}