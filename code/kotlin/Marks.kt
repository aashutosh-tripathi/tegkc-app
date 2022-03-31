package com.kaushal.college

import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_extramarks.*

import kotlinx.android.synthetic.main.activity_marks.*
import kotlinx.android.synthetic.main.prompt_activity.*
import android.widget.TextView



class Marks : AppCompatActivity() {
  lateinit var options: Spinner
    lateinit var result: TextView
    lateinit var myDialog: Dialog
    lateinit var prompt_button_cancel: TextView
    lateinit var prompt_button_ok: TextView
    var teamname=""

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marks)
        options =findViewById(R.id.spinner_id) as Spinner
        val optionarray= arrayOf("Team1","Team2","Team3")
        //functions for spinner
        options.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,optionarray)
        options.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                teamname=parent!!.getItemAtPosition(position).toString()
            }
        }

        //When Upload Button is Clicked

        upload.setOnClickListener(){

            //reference for current user



            //inserting marks in database
            if(marksGiven.text.isNullOrEmpty()){
              //empty string input
               Toast.makeText(this@Marks,"Please Enter Marks Before Uploading",Toast.LENGTH_SHORT).show()
            }
            else if(marksGiven.text.toString().toDouble()>100){
                //Marks greater than 100
                Toast.makeText(this@Marks,"Marks Should Be Less Than Or Equal To 100",Toast.LENGTH_SHORT).show()
            }
            else{
showprompt()
            }
















        }
    }

    fun showprompt(){


        //setting text



        myDialog= Dialog(this)
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        myDialog.setContentView(R.layout.prompt_activity)
        myDialog.setTitle("Prompt")
        prompt_button_cancel=myDialog.findViewById(R.id.prompt_cancel) as TextView
        prompt_button_ok=myDialog.findViewById(R.id.prompt_ok) as TextView
        prompt_button_cancel.isEnabled=true
        prompt_button_ok.isEnabled=true



        val t = myDialog.findViewById(R.id.prompt_team) as TextView
        t.setText(teamname.toString())


        val m = myDialog.findViewById(R.id.prompt_marks) as TextView
        m.setText(marksGiven.text.toString())



        //ok on click listener
        prompt_button_ok.setOnClickListener{

            val auth = FirebaseAuth.getInstance()
            val user = auth.currentUser
            val ref = FirebaseDatabase.getInstance().reference


            ref.child(user!!.uid).child(teamname).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val value:String? = dataSnapshot.getValue(String::class.java)
                    if(!value.isNullOrEmpty() && value!="0")
                    {
                        Toast.makeText(this@Marks,"Marks Already Given",Toast.LENGTH_SHORT).show()

                    }

                    else{

                        ref.child(user!!.uid).child(teamname).setValue(marksGiven.text.toString()).addOnCompleteListener{
                            if(it.isSuccessful){
                                Toast.makeText(this@Marks,"Marks Uploaded Successful",Toast.LENGTH_SHORT).show()
                            }
                            else{
                                Toast.makeText(this@Marks,"check your internet connection",Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
myDialog.cancel()
        }

        //cancel on click

        prompt_button_cancel.setOnClickListener{
            myDialog.cancel()
        }

myDialog.show()


        //setting text

    }


    override fun onBackPressed() {
        Toast.makeText(this,"Please Logout To Go Back",Toast.LENGTH_SHORT).show()
    }

    fun logout(view: View){
        val itemid = view as TextView
        when(itemid.id) {
            R.id.logoutbutton -> {
                super.onBackPressed()
            }
        }
    }

}
