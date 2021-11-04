package com.example.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.newsapp.adapter.SectionPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var vpNews: ViewPager2
    private lateinit var tabs: TabLayout

    private var mSectionPagerAdapter: SectionPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        vpNews = findViewById(R.id.vp_news)
        tabs = findViewById(R.id.tabs)

        mSectionPagerAdapter = SectionPagerAdapter(this)
        vpNews.adapter = mSectionPagerAdapter

        val tabList = arrayOf("All News", "Top", "Populer")
        TabLayoutMediator(tabs, vpNews) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }
}