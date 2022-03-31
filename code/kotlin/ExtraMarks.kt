package com.kaushal.college

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.kaushal.college.R.id.button_id
import kotlinx.android.synthetic.main.activity_extramarks.*

class ExtraMarks : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extramarks)

    }
    fun insertdata(view: View){
        val itemid = view as TextView
        when(itemid.id) {
            R.id.button_id-> {
                val auth = FirebaseAuth.getInstance()
                val user = auth.currentUser
                val ref = FirebaseDatabase.getInstance().reference
                ref.child(user!!.uid).child("team1").setValue(year_id.text.toString())



            }
        }
    }
}
