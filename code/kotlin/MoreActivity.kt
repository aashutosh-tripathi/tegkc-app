package com.kaushal.college

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.lang.System.exit

class MoreActivity : BaseActivity(3) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)
        setUpBottomNav()

    }

    fun moreitems(view: View)
    {
        val itemid = view as TextView
        when(itemid.id)
        {
            R.id.t2->
            {
                val intent = Intent(this,RulebookActivity::class.java)
                startActivity(intent)

            }
            R.id.t3->
            {
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)

            }
            R.id.t4->{
                val intent = Intent(this,ContactusActivity::class.java)
                startActivity(intent)
            }
            R.id.t5->
            {
                val intent = Intent(this,Developed::class.java)
                startActivity(intent)

            }
            R.id.t6->
            {
                val intent = Intent(this,OurTeam::class.java)
                startActivity(intent)

            }
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this,"Press back again to exit",Toast.LENGTH_SHORT).show()
        var intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }
    }


