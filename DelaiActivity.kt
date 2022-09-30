package com.example.retrofitdemo

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.retrofitdemo.api.CreateDelaiRequest
import com.example.retrofitdemo.api.CreateChaiseResponse
import com.example.retrofitdemo.api.Retro
import com.example.retrofitdemo.api.SimpleApi
import com.example.retrofitdemo.login.QIBusSoftUISoftUIDashboardActivity

import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.activity_delai.*
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class DelaiActivity : AppCompatActivity() {

    lateinit var usertv:TextView
    lateinit var btnDelai:Button
    lateinit var btnChoosedate:Button
    lateinit var dateet:EditText
    lateinit var delaiet:EditText



    var ism=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delai)

        val sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString=sharedPreferences.getString("STRING_KEY",null)

        usertv=findViewById(R.id.textView17)
        // putExtra("emaill",strr)
        usertv.text=savedString
        ism=savedString.toString()

        initAction()
    }

    fun initAction() {

        val myCalendar=Calendar.getInstance()
        val datePicker=DatePickerDialog.OnDateSetListener { view, year, month, dayofMonth -> 
            myCalendar.set(Calendar.YEAR,year)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.DAY_OF_MONTH,dayofMonth)
            updateLable(myCalendar)
            
        }

        dateet=findViewById(R.id.editTextDate)
        dateet.setOnClickListener {
            DatePickerDialog(this,datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        delaiet=findViewById(R.id.editTextTime)


        btnDelai=findViewById(R.id.button2)
        btnDelai.setOnClickListener {


//                tbHideOrNot.setVisibility(View.INVISIBLE);

            val dateDelai=editTextDate.text.toString().trim()
            val delai= editTextTime.text.toString().trim()


            if(dateDelai.isEmpty()){
                editTextDate.error="Date vide!"
                editTextDate.requestFocus()
                return@setOnClickListener
            }

            if(delai.isEmpty()){
                editTextTime.error="Delai vide!"
                editTextTime.requestFocus()
                return@setOnClickListener
            }



            createDelai()
        }
    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat="dd-MM-yyyy"
        val sdf=SimpleDateFormat(myFormat,Locale.FRANCE)
        editTextDate.setText(sdf.format(myCalendar.time))

    }


    fun createDelai() {
        val request = CreateDelaiRequest()
        request.userdatas = ism.toString().trim()
        request.Datenotif = editTextDate.text.toString().trim()
        request.delai = editTextTime.text.toString().trim()



        val retro = Retro().getRetroClientInstance().create(SimpleApi::class.java)
        retro.delai(request).enqueue(object : retrofit2.Callback<CreateChaiseResponse> {

            override fun onFailure(call: Call<CreateChaiseResponse>, t: Throwable) {

                Log.d("auth", "ffff")
                t.message?.let { Log.d("auth", it)
                    initgo()

                }
            }

            override fun onResponse(call: Call<CreateChaiseResponse>, response: Response<CreateChaiseResponse>) {
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