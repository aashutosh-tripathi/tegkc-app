package com.kaushal.college

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import java.lang.System.exit

class MapActivity :BaseActivity(2) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        setUpBottomNav()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this,"Press back again to exit",Toast.LENGTH_SHORT).show()
        var intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }
}
