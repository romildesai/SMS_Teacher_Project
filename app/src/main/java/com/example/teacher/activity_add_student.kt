package com.example.teacher

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class activity_add_student : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#014f86")))


    }
}



