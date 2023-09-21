package com.idn.muslimmedia.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.idn.muslimmedia.ui.home.AlJazeeraFragment
import com.idn.muslimmedia.ui.home.AboutAlQuranFragment
import com.idn.muslimmedia.ui.home.CommonFragment
import com.idn.muslimmedia.ui.home.WarningFragment

class SectionPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CommonFragment()
            1 -> AboutAlQuranFragment()
            2 -> AlJazeeraFragment()
            3 -> WarningFragment()
            else -> AlJazeeraFragment()
        }
    }
}