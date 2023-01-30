package com.example.teacher

import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Color.red
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView
import androidx.core.app.NotificationCompat.getColor
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.res.ResourcesCompat.getColor
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#014f86")))

        title="home page"

        val syllabus= findViewById<CardView>(R.id.syllabus)
        syllabus.setOnClickListener{
            val intent = Intent(this,Syllabus::class.java)
            startActivity(intent)
          }

        val marks = findViewById<CardView>(R.id.marks)
        marks.setOnClickListener{
            val intent = Intent(this,Results::class.java)
            startActivity(intent)
        }

        val studentList  = findViewById<CardView>(R.id.student_list)
        studentList.setOnClickListener{
            val intent = Intent(this,Student_List::class.java)
            startActivity(intent)
        }

    }
    }
