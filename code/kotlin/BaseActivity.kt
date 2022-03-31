package com.kaushal.college

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.bottomnavigationbar.*

abstract class BaseActivity(val navNumber:Int=0) :AppCompatActivity() {
    private val tag="BaseActivity"
    fun setUpBottomNav() {

        navigation_view.setTextVisibility(false)
        navigation_view.enableAnimation(false)
        navigation_view.enableItemShiftingMode(false)
        navigation_view.enableShiftingMode(false)
        for (i in 0 until navigation_view.menu.size()) {
            navigation_view.setIconTintList(i, null)
        }
        navigation_view.setOnNavigationItemSelectedListener {
            val nextAct =
                    when (it.itemId) {
                        R.id.item_home -> HomeActivity::class.java
                        R.id.item_lead -> LeadActivity::class.java
                        R.id.item_more-> MoreActivity::class.java
                        R.id.item_map -> MapActivity::class.java

                        else -> {
                            null
                        }
                    }
            if (nextAct !=null) {
                val intent = Intent(this, nextAct)
                intent.flags=Intent.FLAG_ACTIVITY_NO_ANIMATION

                startActivity(intent)
                overridePendingTransition(0,0)
                true
            } else {
                false
            }
        }
        navigation_view.menu.getItem(navNumber).isChecked=true
    }

}