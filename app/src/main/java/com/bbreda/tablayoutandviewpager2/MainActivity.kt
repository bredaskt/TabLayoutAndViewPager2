package com.bbreda.tablayoutandviewpager2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkIfUserAlreadyVisitTheTutorial()
    }

    private fun checkIfUserAlreadyVisitTheTutorial() {
        var PRIVATE_MODE = 0
        val PREF_NAME = "if_user_already_visit_tablayout_and_view_pager2"
        val sharedPref: SharedPreferences = getSharedPreferences(PREF_NAME, PRIVATE_MODE)

        if (sharedPref.getBoolean(PREF_NAME, false)) {
            val homeIntent = Intent(this, HomeActivity::class.java)
            startActivity(homeIntent)
            finish()
        } else {
            setupViewPager()
            val editor = sharedPref.edit()
            editor.putBoolean(PREF_NAME, true)
            editor.apply()
        }
    }

    private fun createCardAdapter(): ViewPagerAdapter {
        return ViewPagerAdapter(this)
    }

    private fun setupViewPager() {
        setContentView(R.layout.activity_main)
        view_pager.adapter = createCardAdapter()
        TabLayoutMediator(tabs, view_pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = "Tab " + (position + 1)
            }).attach()
    }

}