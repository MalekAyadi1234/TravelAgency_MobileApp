package com.example.retrofitdemo.admin

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitdemo.R
import com.example.retrofitdemo.api.*
import kotlinx.android.synthetic.main.activity_ajoutmat.*
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.activity_delai.*
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class AjoutMatActivity : AppCompatActivity() {

    lateinit var radioiphone:RadioButton
    lateinit var radiomacos:RadioButton
    lateinit var radiowearos:RadioButton
    lateinit var name:EditText
    lateinit var radiofalse:RadioButton
    lateinit var radiotrue:RadioButton
    lateinit var btnSubmit:Button
    lateinit var btndatematerial:Button
    lateinit var datee:EditText
    lateinit var time1:EditText
    lateinit var time2:EditText

    var radiotype=""
    var radioDispo="true"

    var var1=""
    var var2=""
    var var3=""
    var var4=""
    var var5=""
    var var6=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajoutmat)



        initAction()
    }

    fun initAction() {




       /* if(radioiphone.isChecked && radiomacos.isChecked && radiowearos.isChecked){

            Toast.makeText(this,"You should only choose one",Toast.LENGTH_SHORT).show()

        }
        if(!radioiphone.isChecked && !radiomacos.isChecked && !radiowearos.isChecked){

            Toast.makeText(this,"You should only choose one",Toast.LENGTH_SHORT).show()

        }*/


//date picker

        val myCalendar=Calendar.getInstance()
        val datePicker= DatePickerDialog.OnDateSetListener { view, year, month, dayofMonth ->
            myCalendar.set(Calendar.YEAR,year)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.DAY_OF_MONTH,dayofMonth)
            updateLable(myCalendar)

        }


        //TIME PICKER
        time1=findViewById(R.id.fromheure)
        time1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                // TODO Auto-generated method stub
                val mcurrentTime = Calendar.getInstance()
                val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
                val minute = mcurrentTime[Calendar.MINUTE]
                val mTimePicker: TimePickerDialog
                mTimePicker = TimePickerDialog(this@AjoutMatActivity,
                    { timePicker, selectedHour, selectedMinute -> time1.setText("$selectedHour:$selectedMinute") },
                    hour,
                    minute,
                    true
                )
                mTimePicker.setTitle("Select Time")
                mTimePicker.show()
            }
        })

        time2=findViewById(R.id.toheure)
        time2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                // TODO Auto-generated method stub
                val mcurrentTime = Calendar.getInstance()
                val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
                val minute = mcurrentTime[Calendar.MINUTE]
                val mTimePicker: TimePickerDialog
                mTimePicker = TimePickerDialog(this@AjoutMatActivity,
                    { timePicker, selectedHour, selectedMinute -> time2.setText("$selectedHour:$selectedMinute") },
                    hour,
                    minute,
                    true
                )
                mTimePicker.setTitle("Select Time")
                mTimePicker.show()
            }
        })

        //DATE PICKER
        datee=findViewById(R.id.datedispo)
        datee.setOnClickListener {
            DatePickerDialog(this,datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()

        }

        btnSubmit=findViewById(R.id.button5)
        btnSubmit.setOnClickListener {

            radioiphone=findViewById(R.id.radioiphone)
            radiomacos=findViewById(R.id.radiomac)
            radiowearos=findViewById(R.id.radiowearos)

            if(radioiphone.isChecked){
                radiotype="vip"
            }
            if(radiomacos.isChecked){
                radiotype="food"
            }
            if (radiowearos.isChecked){

                radiotype="transport"
            }



//                tbHideOrNot.setVisibility(View.INVISIBLE);

          //  val dateDelai=editTextDate.text.toString().trim()


            val matNamee=matName.text.toString().trim()
            var1=matNamee.toString().trim()


            val dateDispo=datedispo.text.trim()
            var2=dateDispo.toString().trim()

            val date1: Date = SimpleDateFormat("yyyy-MM-dd").parse(var2)

            val from=fromheure.text.toString().trim()
            var3=from.toString().trim()



            val to=toheure.text.toString().trim()
            var4=to.toString().trim()
            val duration=duree.text.toString().trim()
            var5=duration.toString().trim()





            if(matNamee.isEmpty()){
                matName.error="name vide!"
                matName.requestFocus()
                return@setOnClickListener
            }
            if(dateDispo.isEmpty()){
                datedispo.error="Date vide!"
                datedispo.requestFocus()
                return@setOnClickListener
            }
            if(from.isEmpty()){
                fromheure.error="fromHeure vide!"
                fromheure.requestFocus()
            return@setOnClickListener
        }
            if(to.isEmpty()){
                toheure.error="Toheure vide!"
                toheure.requestFocus()
            return@setOnClickListener
        }
            if(duration.isEmpty()){
                duree.error="Duree vide!"
                duree.requestFocus()
            return@setOnClickListener
        }






            val request = CreateMatRequest()
            //request.Datenotif = editTextDate.text.toString().trim()
            /*   request.type = radiotype.toString().trim()
               request.nom_materiel=matName.toString().trim()
               request.date_dispo=datedispo.toString().trim()
               request.heure_debut=fromheure.toString().trim()
               request.heure_fin=toheure.toString().trim()
               request.duree=duree.toString().trim()
               request.image=duree.toString().trim()
               request.disponibilite=radioDispo.toString().trim()*/

            request.type = radiotype.trim()
            request.nom_materiel=var1.trim()
            request.date_dispo=date1
            request.heure_debut=var3.trim()
            request.heure_fin=var4.trim()
            request.duree=var5.trim()
            request.image=var5.trim()
            request.disponibilite=radioDispo.toString().trim()







            val retro = Retro().getRetroClientInstance().create(SimpleApi::class.java)
            retro.createMat(request).enqueue(object : retrofit2.Callback<CreateMatResponse> {

                override fun onFailure(call: Call<CreateMatResponse>, t: Throwable) {

                    Log.d("auth", "ffff")
                    t.message?.let { Log.d("auth", it)
                        initgo()

                    }
                }

                override fun onResponse(call: Call<CreateMatResponse>, response: Response<CreateMatResponse>) {
                    Log.d("auth", response.code().toString())
                    initgo()

                }

            })
        }
    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat="dd-MM-yyyy"
        val sdf=SimpleDateFormat(myFormat,Locale.FRANCE)
        datedispo.setText(sdf.format(myCalendar.time))

    }


    fun initgo() {
        val intent = Intent(this, HomeEnseignantActivity::class.java).apply { }
        startActivity(intent)
        Toast.makeText(applicationContext,"Added Successfully", Toast.LENGTH_LONG).show()
    }



}