package com.example.teacher

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.icu.util.Calendar
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.radiobutton.MaterialRadioButton
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Add_Student : AppCompatActivity() {

    private lateinit var fname: EditText
    private lateinit var enroll: EditText
    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var gender: RadioGroup
    private lateinit var dob: EditText
    private lateinit var phone: EditText
    private lateinit var sem: EditText
    private lateinit var cls: EditText
    private lateinit var branch: EditText
    private lateinit var fees_paid: MaterialRadioButton
    private lateinit var male_as: MaterialRadioButton
    private lateinit var female_as: MaterialRadioButton



    private lateinit var btn_addstud: Button

    private lateinit var Dbref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student2)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#014f86")))
        title = "Add Students"

        fname = findViewById(R.id.txt_as_fname)
        enroll = findViewById(R.id.txt_as_enrollment)
        email = findViewById(R.id.txt_as_email)
        pass = findViewById(R.id.txt_as_pass)
        male_as = findViewById(R.id.gen_as_male)
        dob = findViewById(R.id.txt_as_dob)
        phone = findViewById(R.id.txt_as_phone)
        sem = findViewById(R.id.txt_as_semester)
        cls = findViewById(R.id.txt_as_class)
        branch = findViewById(R.id.txt_as_branch)
        fees_paid = findViewById(R.id.fees_paid)



        btn_addstud = findViewById(R.id.btn_addStudent)
        Dbref = FirebaseDatabase.getInstance().getReference("Student")

//        gender.setOnCheckedChangeListener { group, i ->
//            if (i == R.id.gen_as_male) {
//                Toast.makeText(this, "male", Toast.LENGTH_SHORT).show()
//            }
//            if (i == R.id.gen_as_female) {
//                Toast.makeText(this, "female", Toast.LENGTH_SHORT).show()
//            }
//        }
        btn_addstud.setOnClickListener {
            saveStudentData()

            val email = email.text.toString()


        }

        dob.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DATE)

            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->

                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    dob.setText(dat)
                },
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
        var gen : String = ""
        if (male_as.isChecked()) {
            gen = "Male"
        } else {
            gen = "Female"
        }
        val Dob = dob.text.toString()
        val phne = phone.text.toString()
        val sem = sem.text.toString()
        val cls = cls.text.toString()
        val branch = branch.text.toString()
        var fee  : String = ""
        if (fees_paid.isChecked())
        {
            fee = "Paid"
        }else{
            fee = "Unpaid"
        }



        val Student = StudentModel(fullname, enrollment, email, password,gen,Dob,phne,sem,cls,branch,fee)

        Dbref.child(enrollment).setValue(Student)
            .addOnCompleteListener {
                Toast.makeText(this, "Student Record Added", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Student_List::class.java)
                startActivity(intent)
            }
            .addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
            }
    }

}
