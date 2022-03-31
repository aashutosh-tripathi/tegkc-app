package com.kaushal.college

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Developed : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.developedby_activity)
    }
    override fun onBackPressed() {
        super.onBackPressed()

        var intent = Intent(this,MoreActivity::class.java)
        startActivity(intent)
    }
}
