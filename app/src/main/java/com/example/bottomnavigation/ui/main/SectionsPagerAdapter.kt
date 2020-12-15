package com.example.bottomnavigation.ui.main


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.bottomnavigation.ProfileCompletion
import java.util.*

/*private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2
)*/


class SectionsPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(
    fm!!
) {
    private val fragmentList: MutableList<Fragment> = ArrayList()
    private val titleList: MutableList<String> = ArrayList()
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
    }
}