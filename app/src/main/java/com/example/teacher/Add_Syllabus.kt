package com.example.teacher

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Add_Syllabus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_syllabus)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#014f86")))

    }
}