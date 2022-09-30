package com.example.retrofitdemo.admin

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdemo.MainViewModel
import com.example.retrofitdemo.R
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_delai.*
import kotlinx.android.synthetic.main.row_layout.view.*
import java.text.SimpleDateFormat
import java.util.*

class AddSeanceActivity : AppCompatActivity() {

    lateinit var numET:EditText
    lateinit var dateET:EditText
    lateinit var heureD:EditText
    lateinit var heureF:EditText
    lateinit var dureeS:EditText
    lateinit var addSeancebtn:Button
    lateinit var btndateseance:Button

    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_seance)


        val myCalendar= Calendar.getInstance()
        val datePicker= DatePickerDialog.OnDateSetListener { view, year, month, dayofMonth ->
            myCalendar.set(Calendar.YEAR,year)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.DAY_OF_MONTH,dayofMonth)
            updateLable(myCalendar)

        }

        numET=findViewById(R.id.editTextNumSeance)

        dateET=findViewById(R.id.editTextDateSeance)
        dateET.setOnClickListener {
            DatePickerDialog(this,datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()

        }

        heureD=findViewById(R.id.editTextTimedebut)
        heureD.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                // TODO Auto-generated method stub
                val mcurrentTime = Calendar.getInstance()
                val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
                val minute = mcurrentTime[Calendar.MINUTE]
                val mTimePicker: TimePickerDialog
                mTimePicker = TimePickerDialog(this@AddSeanceActivity,
                    { timePicker, selectedHour, selectedMinute -> heureD.setText("$selectedHour:$selectedMinute") },
                    hour,
                    minute,
                    true
                )
                mTimePicker.setTitle("Select Time")
                mTimePicker.show()
            }
        })

        heureF=findViewById(R.id.editTextTimefin)
        heureF.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                // TODO Auto-generated method stub
                val mcurrentTime = Calendar.getInstance()
                val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
                val minute = mcurrentTime[Calendar.MINUTE]
                val mTimePicker: TimePickerDialog
                mTimePicker = TimePickerDialog(this@AddSeanceActivity,
                    { timePicker, selectedHour, selectedMinute -> heureF.setText("$selectedHour:$selectedMinute") },
                    hour,
                    minute,
                    true
                )
                mTimePicker.setTitle("Select Time")
                mTimePicker.show()
            }
        })

        dureeS=findViewById(R.id.editTextDuree)
       /* btndateseance=findViewById(R.id.buttondateseance)
        //datePicker
        btndateseance.setOnClickListener {
            DatePickerDialog(this,datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()

        }*/

        addSeancebtn=findViewById(R.id.buttonAddSeance)
        addSeancebtn.setOnClickListener {

            val repository = Repository()
            val viewModelFactory = MainViewModelFactory(repository)
            viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

            // val id = intent.getStringExtra("id")

            viewModel.addSeance(numET.text.toString().toInt(),dateET.text.toString(),heureD.text.toString(),heureF.text.toString(),dureeS.text.toString().toInt())

            Toast.makeText(applicationContext,"Added Successfully", Toast.LENGTH_LONG).show()
            val intent = Intent(this@AddSeanceActivity, HomeEnseignantActivity::class.java).apply {


            }
            startActivity(intent)

        }

    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat="dd-MM-yyyy"
        val sdf= SimpleDateFormat(myFormat,Locale.FRANCE)
        dateET.setText(sdf.format(myCalendar.time))

    }
}