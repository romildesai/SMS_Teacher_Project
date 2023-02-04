package com.example.teacher

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class Add_Student : AppCompatActivity() {

    private lateinit var fname : EditText
    private lateinit var enroll: EditText
    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var gender:RadioGroup
    private lateinit var dob : EditText
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
        title="Add Students"

        fname = findViewById(R.id.txt_as_fname)
        enroll = findViewById(R.id.txt_as_enrollment)
        email = findViewById(R.id.txt_as_email)
        pass = findViewById(R.id.txt_as_pass)
        gender = findViewById(R.id.as_gender)
        dob = findViewById(R.id.txt_as_dob)
        phone = findViewById(R.id.txt_as_phone)
        sem = findViewById(R.id.txt_as_semester)
        cls = findViewById(R.id.txt_as_class)
        branch=findViewById(R.id.txt_as_branch)
        fees = findViewById(R.id.txt_as_fees)



        btn_addstud = findViewById(R.id.btn_addStudent)
        Dbref = FirebaseDatabase.getInstance().getReference("Student")

        btn_addstud.setOnClickListener {
            saveStudentData()
        }

        dob.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day  = c.get(Calendar.DATE)

            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    // on below line we are setting
                    // date to our edit text.
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    dob.setText(dat)
                },
                // on below line we are passing year, month
                // and day for the selected date in our date picker.
                year,
                month,
                day

            )
            datePickerDialog.show()

        }


    }

    private fun saveStudentData() {

        val fullname = fname.text.toString()
        val enrollment = enroll.text.toString()
        val email = email.text.toString()
        val password = pass.text.toString()
        val gen = gender.toString()
        if (male_as.isChecked())
        {

        }
        val Dob = dob.text.toString()




        val Student = StudentModel(fullname,enrollment,email,password,Dob)

        Dbref.child(enrollment).setValue(Student)
            .addOnCompleteListener{
                Toast.makeText(this, "Student Record Added", Toast.LENGTH_SHORT).show()



            }
            .addOnFailureListener{err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
            }
    }

    }
