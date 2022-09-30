package com.example.retrofitdemo.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.retrofitdemo.R
import com.example.retrofitdemo.api.*
import kotlinx.android.synthetic.main.activity_ajoutmat.*
import retrofit2.Call
import retrofit2.Response
import java.util.*

class AddChaiseAdminActivity : AppCompatActivity() {

    lateinit var seatName: EditText
    lateinit var addBtn: Button
    var var1 = ""
    var var2 = "true"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_chaise_admin)
        initAction()
    }

    fun initAction() {


        /* if(radioiphone.isChecked && radiomacos.isChecked && radiowearos.isChecked){

             Toast.makeText(this,"You should only choose one",Toast.LENGTH_SHORT).show()

         }
         if(!radioiphone.isChecked && !radiomacos.isChecked && !radiowearos.isChecked){

             Toast.makeText(this,"You should only choose one",Toast.LENGTH_SHORT).show()

         }*/




        addBtn = findViewById(R.id.button6)
        addBtn.setOnClickListener {


//                tbHideOrNot.setVisibility(View.INVISIBLE);

            //  val dateDelai=editTextDate.text.toString().trim()

            seatName=findViewById(R.id.seatnameet)
            val matNamee = seatName.text.toString().trim()
            var1 = matNamee.toString().trim()






            if (matNamee.isEmpty()) {
                seatName.error = "name vide!"
                seatName.requestFocus()
                return@setOnClickListener
            }


            val request = CreateChaiseRequest()
            //request.Datenotif = editTextDate.text.toString().trim()
            /*   request.type = radiotype.toString().trim()
               request.nom_materiel=matName.toString().trim()
               request.date_dispo=datedispo.toString().trim()
               request.heure_debut=fromheure.toString().trim()
               request.heure_fin=toheure.toString().trim()
               request.duree=duree.toString().trim()
               request.image=duree.toString().trim()
               request.disponibilite=radioDispo.toString().trim()*/

            request.num_chaise = var1.trim()
            request.disponibilite = var2.toBoolean()


            val retro = Retro().getRetroClientInstance().create(SimpleApi::class.java)
            retro.createChaise(request).enqueue(object : retrofit2.Callback<CreateChaiseResponse> {

                override fun onFailure(call: Call<CreateChaiseResponse>, t: Throwable) {

                    Log.d("auth", "ffff")
                    t.message?.let {
                        Log.d("auth", it)
                        initgo()

                    }
                }

                override fun onResponse(
                    call: Call<CreateChaiseResponse>,
                    response: Response<CreateChaiseResponse>
                ) {
                    Log.d("auth", response.code().toString())
                    initgo()

                }

            })
        }
    }


    fun initgo() {
        val intent = Intent(this, HomeEnseignantActivity::class.java).apply { }
        startActivity(intent)
        Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
    }
}