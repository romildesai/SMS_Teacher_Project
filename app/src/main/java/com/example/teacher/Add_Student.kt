package com.example.teacher

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Add_Student : AppCompatActivity() {

    private lateinit var fname : EditText
    private lateinit var enroll: EditText
    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var gender:RadioGroup
    private lateinit var bob : EditText
    private lateinit var phone : EditText
    private lateinit var sem : EditText
    private lateinit var cls : EditText
    private lateinit var branch:EditText
    private lateinit var fees : EditText
    private lateinit var male_as:RadioButton

    private lateinit var btn_addstud : Button

    private lateinit var Dbref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student2)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#014f86")))

        fname = findViewById(R.id.txt_as_fname)
        enroll = findViewById(R.id.txt_as_enrollment)
        email = findViewById(R.id.txt_as_email)
        pass = findViewById(R.id.txt_as_pass)
        male_as= findViewById(R.id.gen_as_female)


        btn_addstud = findViewById(R.id.btn_addStudent)
        Dbref = FirebaseDatabase.getInstance().getReference("Student")

        btn_addstud.setOnClickListener {
            saveStudentData()
        }



    }

    private fun saveStudentData() {

        val fullname = fname.text.toString()
        val enrollment = enroll.text.toString()
        val email = email.text.toString()
        val password = pass.text.toString()



        val Student = StudentModel(fullname,enrollment,email,password)

        Dbref.child(enrollment).setValue(Student)
            .addOnCompleteListener{
                Toast.makeText(this, "Student Record Added", Toast.LENGTH_SHORT).show()



            }
            .addOnFailureListener{err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
            }
    }

    }
