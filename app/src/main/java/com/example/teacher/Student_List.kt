package com.example.teacher

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Student_List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#014f86")))

        val ftb = findViewById<FloatingActionButton>(R.id.floating_addstudent)
        ftb.setOnClickListener {
            val intent = Intent(this,Add_Student::class.java)
            startActivity(intent)
        }

    }
}