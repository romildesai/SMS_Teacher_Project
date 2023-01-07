package com.example.teacher

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Syllabus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syllabus )


        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#014f86")))

        val fab = findViewById<FloatingActionButton>(R.id.add_fab)
        fab.setOnClickListener{
            val intent = Intent(this,Add_Syllabus::class.java)
            startActivity(intent)
        }




    }
}