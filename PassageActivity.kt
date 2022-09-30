package com.example.retrofitdemo

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.retrofitdemo.api.CreatePassageRequest
import com.example.retrofitdemo.api.CreatePassageResponse
import com.example.retrofitdemo.api.Retro
import com.example.retrofitdemo.api.SimpleApi
import com.example.retrofitdemo.login.QIBusSoftUISoftUIDashboardActivity
import kotlinx.android.synthetic.main.activity_delai.*
import kotlinx.android.synthetic.main.activity_passage.*
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class PassageActivity : AppCompatActivity() {
    lateinit var btnPassage: Button
    lateinit var newEmail:TextView
    lateinit var datePass:TextView
    lateinit var usertv:TextView
    lateinit var btnChoosedd:Button
    lateinit var dateeee:EditText

    var ism=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passage)



        val sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString=sharedPreferences.getString("STRING_KEY",null)

        usertv=findViewById(R.id.textView19)
        // putExtra("emaill",strr)
       usertv.text=savedString
        ism=savedString.toString()

        initAction()
    }

    fun initAction() {


        val myCalendar= Calendar.getInstance()
        val datePicker= DatePickerDialog.OnDateSetListener { view, year, month, dayofMonth ->
            myCalendar.set(Calendar.YEAR,year)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.DAY_OF_MONTH,dayofMonth)
            updateLable(myCalendar)

        }
        dateeee=findViewById(R.id.editTextDate2)
        dateeee.setOnClickListener {
            DatePickerDialog(this,datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        newEmail=findViewById(R.id.editTextTextEmailAddress)
        datePass=findViewById(R.id.editTextDate2)
        btnPassage=findViewById(R.id.button3)
        btnPassage.setOnClickListener {


//                tbHideOrNot.setVisibility(View.INVISIBLE);

            val newstudentmail=newEmail.text.toString().trim()
            val passagedate= datePass.text.toString().trim()


            if(newstudentmail.isEmpty()){
                newEmail.error="new email vide!"
                newEmail.requestFocus()
                return@setOnClickListener
            }

            if(passagedate.isEmpty()){
                datePass.error="date vide!"
                datePass.requestFocus()
                return@setOnClickListener
            }



            createPassage()
        }
    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat="dd-MM-yyyy"
        val sdf= SimpleDateFormat(myFormat,Locale.FRANCE)
        datePass.setText(sdf.format(myCalendar.time))

    }


    private fun createPassage() {
        val request = CreatePassageRequest()
        request.userdatas = ism.trim()
        request.newemail = newEmail.text.toString().trim()
        request.date_passage = datePass.text.toString().trim()



        val retro = Retro().getRetroClientInstance().create(SimpleApi::class.java)
        retro.passage(request).enqueue(object : retrofit2.Callback<CreatePassageResponse> {

            override fun onFailure(call: Call<CreatePassageResponse>, t: Throwable) {

                Log.d("auth", "ffff")
                t.message?.let { Log.d("auth", it)
                    initgo()

                }
            }

            override fun onResponse(call: Call<CreatePassageResponse>, response: Response<CreatePassageResponse>) {
                Log.d("auth", response.code().toString())
                initgo()

            }

        })
    }

    fun initgo() {
        val intent = Intent(this, QIBusSoftUISoftUIDashboardActivity::class.java).apply { }
        startActivity(intent)
        Toast.makeText(applicationContext,"Success", Toast.LENGTH_LONG).show()
    }

}