package com.idn.muslimmedia

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.tabs.TabLayoutMediator
import com.idn.muslimmedia.adapter.SectionPagerAdapter
import com.idn.muslimmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)

        setupViewPager()
    }

    private fun setupViewPager() {
        binding.vpNews.adapter = SectionPagerAdapter(this)

        val tabList = arrayOf(
            "Common",
            "About Al Quran",
            "Al Jazeera",
            "Warn For Muslim",
        )
        TabLayoutMediator(binding.tabs, binding.vpNews) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        // Get the SearchView and set the searchable configuration
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.option_search)?.actionView as SearchView).apply {
            // Assumes current activity is the searchable activity
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return true
    }

    /*
    //  when will use search dialog by clicked option menu search
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.option_search -> {
                    onSearchRequested()
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
        }
    */
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}