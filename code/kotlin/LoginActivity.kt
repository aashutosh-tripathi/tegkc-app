package com.kaushal.college

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View) {
        val email=email_id.text.toString()
        val password=password_id.text.toString()
        if(validate(email,password)) {
            mAuth!!.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    startActivity(Intent(this, Marks::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Please enter valid email and password", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else
        {
            Toast.makeText(this, "Email and Password fields should not be empty", Toast.LENGTH_SHORT).show()
        }
    }

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance();
        login_button.setOnClickListener(this)

    }
    private fun validate(email: String,password :String)=email.isNotEmpty() && password.isNotEmpty()
}
