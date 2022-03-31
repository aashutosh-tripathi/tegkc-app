package com.kaushal.college

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.barteksc.pdfviewer.PDFView

class RulebookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rulebook)

        val pd= findViewById<PDFView>(R.id.pdf)
      pd.fromAsset("rulebook.pdf").load()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        var intent = Intent(this,MoreActivity::class.java)
        startActivity(intent)
    }
}
