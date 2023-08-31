package com.idn.muslimmedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.idn.muslimmedia.adapter.SectionPagerAdapter
import com.idn.muslimmedia.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.vpNews.adapter = SectionPagerAdapter(this)

        val tabList = arrayOf("All News", "Top", "Populer")
        TabLayoutMediator(binding.tabs, binding.vpNews) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }
}