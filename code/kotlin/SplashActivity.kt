package com.kaushal.college

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(
                {
                    val startact=Intent(this@SplashActivity,HomeActivity::class.java)
                    startActivity(startact)
                    this.finish()
                },2000
        )

    }
}
