package com.example.retrofitdemo.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.retrofitdemo.R
import com.example.retrofitdemo.login.NewLoginActivity

class HomeEnseignantActivity : AppCompatActivity() {



    lateinit var buttonScan: ImageView
    lateinit var buttonPresence:ImageView
    lateinit var buttonMaterielEmp:ImageView
    lateinit var buttonreservationSeance:ImageView
    lateinit var buttonPassCle:ImageView
    lateinit var buttonRetard:ImageView


    //lateinit var buttonAccountmenu:ImageView
    //lateinit var buttonAccountmenu:ImageView
    //lateinit var buttonAccountmenu:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_enseignant)



       buttonScan=findViewById(R.id.buttonScannnn)
        buttonScan.setOnClickListener {

            val i= Intent(this,QrscannerActivity::class.java)
            startActivity(i)
        }


        buttonPresence=findViewById(R.id.listePresence)
        buttonPresence.setOnClickListener {

            val i= Intent(this,preesenceActivity::class.java)
           startActivity(i)
             // val i= Intent(this,AjoutMatActivity::class.java)
             //startActivity(i)
        }



        buttonMaterielEmp=findViewById(R.id.matEmpp)
        buttonMaterielEmp.setOnClickListener {

            val i= Intent(this,ReservationMatActivity::class.java)
            startActivity(i)
        }



        buttonreservationSeance=findViewById(R.id.reservationseance)
        buttonreservationSeance.setOnClickListener {

            val i= Intent(this,ReservationChaiseActivity::class.java)
            startActivity(i)
        }



      /*  buttonPassCle=findViewById(R.id.passagecle)
        buttonPassCle.setOnClickListener {

            val i= Intent(this,PassageActivity::class.java)
            startActivity(i)
        }
*/


        buttonRetard=findViewById(R.id.delai)
        buttonRetard.setOnClickListener {

            val i= Intent(this,DelaiActivity::class.java)
            startActivity(i)
        }





    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater= menuInflater
        inflater.inflate(R.menu.menu_item,menu)
        return  true

      //  return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
when (item.itemId) {
    R.id.add_materiel ->{
        Toast.makeText(this, "Add Extra", Toast.LENGTH_SHORT).show()
         val i= Intent(this,AjoutMatActivity::class.java)
        startActivity(i)
    return true
}

    R.id.add_Seance ->{
        Toast.makeText(this, "Add Session", Toast.LENGTH_SHORT).show()
        val i= Intent(this,AddSeanceActivity::class.java)
        startActivity(i)
        return true
    }


   /* R.id.listChaise ->{
        Toast.makeText(this, "profile clicked", Toast.LENGTH_SHORT).show()
        val i= Intent(this,ListSeatActivity::class.java)
        startActivity(i)
        return true
    }
*/

    //


    R.id.listSeance ->{
        Toast.makeText(this, "List Trips", Toast.LENGTH_SHORT).show()
        val i= Intent(this,ListSeancesActivity::class.java)
        startActivity(i)
        return true
    }

    R.id.listeMat ->{
        Toast.makeText(this, "List Extras", Toast.LENGTH_SHORT).show()
        val i= Intent(this,ListMatActivity::class.java)
        startActivity(i)
        return true
    }
    R.id.Logout ->{
        Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
        val i= Intent(this,NewLoginActivity::class.java)
        startActivity(i)
        return true
    }
    else ->  {
        return super.onOptionsItemSelected(item)
    }






}

    }

    //


}