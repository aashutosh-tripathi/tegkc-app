package com.kaushal.college

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.CalendarContract
import android.support.v4.widget.SwipeRefreshLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_lead.*
import java.lang.System.exit
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class LeadActivity : BaseActivity(1) {

    var tm1: Double =0.0
    var tm2: Double =0.0
    var tm3: Double =0.0
    var flag1:Int=0
    var flag2:Int=0
    var flag3:Int=0

    private lateinit var mHandler: Handler
    private lateinit var mRunnable:Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lead)
        setUpBottomNav()
        //Internet Connectivity Check
        val cm=baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo=cm.activeNetworkInfo
        if(netInfo!=null && netInfo.isConnected)
        {
            internetcheck.setText("PULL TO REFRESH")
        }
        else{
            internetcheck.setText("PLEASE CHECK YOUR NETWORK CONNECTION")
        }
        //Leaderboard

        val auth= FirebaseAuth.getInstance()
        val user=auth.currentUser
        val ref=FirebaseDatabase.getInstance().reference
        val Judge1="HJTkfQOBzbQq8LYpZnSvjpqfSq42"
        val Judge2="ITlL9bh1i7fwajtC2VadcqhxrRl2"
        val Judge3="j9uMZSyX7zf3OgQehg6J1H6OTjX2"
       ref.child(Judge3).addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(data: DataSnapshot) {
                val user=data.getValue(Dataclass::class.java)
                    tm1= tm1!! +(user!!.Team1).toDouble()
                tm2= tm2!! +(user!!.Team2).toDouble()
                tm3= tm3!! +(user!!.Team3).toDouble()

                if(user!!.Team1!="0") {
                    flag1 = flag1 + 1
                }
                if(user!!.Team2!="0") {
                    flag2 = flag2 + 1
                }
                if(user!!.Team3!="0") {
                    flag3 = flag3 + 1
                }

            }

        }
        )
        ref.child(Judge1).addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(data: DataSnapshot) {
                val user=data.getValue(Dataclass::class.java)
                tm1= tm1!! +(user!!.Team1).toDouble()
                tm2= tm2!! +(user!!.Team2).toDouble()
                tm3= tm3!! +(user!!.Team3).toDouble()

                if(user!!.Team1!="0") {
                    flag1 = flag1 + 1
                }
                if(user!!.Team2!="0") {
                    flag2 = flag2 + 1
                }
                if(user!!.Team3!="0") {
                    flag3 = flag3 + 1
                }


            }

        }
        )
        ref.child(Judge2).addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(data: DataSnapshot) {
                val user=data.getValue(Dataclass::class.java)
                tm1= tm1!! +(user!!.Team1).toDouble()
                tm2= tm2!! +(user!!.Team2).toDouble()
                tm3= tm3!! +(user!!.Team3).toDouble()



                if(user!!.Team1!="0") {
                    flag1 = flag1 + 1
                }
                if(user!!.Team2!="0") {
                    flag2 = flag2 + 1
                }
                if(user!!.Team3!="0") {
                    flag3 = flag3 + 1
                }



                if(flag1>=3) {
                    marks_team1.setText(String.format("%.1f", tm1.div(3)))
                }
                if(flag2>=3) {
                    marks_team2.setText(String.format("%.1f", tm2.div(3)))
                }
                if(flag3>=3) {
                    marks_team3.setText(String.format("%.1f", tm3.div(3)))
                }

            }

        }
        )





        //Refresh

        mHandler = Handler()
        swipe_refresh_layout.setColorSchemeColors(resources.getColor(R.color.pink), resources.getColor(R.color.blue))
        swipe_refresh_layout.setOnRefreshListener {
            mRunnable = Runnable {
                finish()
                val intent=Intent(this,LeadActivity::class.java)
                startActivity(intent)
                overridePendingTransition(0, 0)
                swipe_refresh_layout.isRefreshing = false
            }

            mHandler.postDelayed(
                    mRunnable,
                    (5000).toLong()
            )
        }


    }
    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this,"Press back again to exit",Toast.LENGTH_SHORT).show()
        var intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }

    }

