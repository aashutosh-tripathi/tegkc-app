package com.kaushal.college

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class CustompagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm){



    var mfm=fm
    var mFragmentItems:ArrayList<Fragment> = ArrayList()
    var mFragmentTitles:ArrayList<String> = ArrayList()

    fun addFragment(fragmentItems:Fragment,fragmentTitles:String)
    {
        mFragmentItems.add(fragmentItems)
        mFragmentTitles.add(fragmentTitles)
    }

    override fun getItem(position: Int): Fragment {
      return mFragmentItems[position]
    }

    override fun getCount(): Int {
   return mFragmentItems.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position)
        {
            0-> return "TEGKC"
            1-> return "TEAMS"
            else-> return null
        }
    }
}