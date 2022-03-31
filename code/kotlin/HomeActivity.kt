package com.kaushal.college

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.widget.Toast
import com.github.abdularis.piv.ScrollTransformImageView
import com.kaushal.college.fragment.TeamFragment
import com.kaushal.college.fragment.TegkcFragment
import kotlinx.android.synthetic.main.activity_home.*
import java.lang.System.exit
import kotlin.system.exitProcess

class HomeActivity : BaseActivity(0) {
     var pageAdapter:CustompagerAdapter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpBottomNav()
        setSupportActionBar(toolbar)
        pageAdapter= CustompagerAdapter(supportFragmentManager)
        pageAdapter!!.addFragment(TegkcFragment(),"TEGKC")
        pageAdapter!!.addFragment(TeamFragment(),"TEAMS")
        customViewPager.adapter=pageAdapter
        customTablayout.setupWithViewPager(customViewPager)
        customTablayout.setTabTextColors(resources.getColor(R.color.blue).plus(2),resources.getColor(R.color.white))


    }


    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
        exitProcess(-1)
    }

}
