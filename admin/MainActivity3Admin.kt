package com.example.retrofitdemo.admin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemo.MainViewModel
import com.example.retrofitdemo.R
import com.example.retrofitdemo.adapter.admin.MySeatAdapterrrr2
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main_activity3_admin.*

class MainActivity3Admin : AppCompatActivity() {

    private var gridLayoutMananager: GridLayoutManager?=null
    private lateinit var viewModel: MainViewModel
    var idd = ""
    var datedate = ""

    private val myAdapter by lazy { MySeatAdapterrrr2(idd,datedate) }

    override fun onCreate(savedInstanceState: Bundle?) {

       // putExtra("id", myList[position].id)

        val iddd = intent.getStringExtra("id")
        Log.d("yaMallouka ", iddd);
        idd=iddd.toString()

        saveData()



        val daaate = intent.getStringExtra("date")
        Log.d("yaMallouka ", daaate);
        datedate=daaate.toString()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity3_admin)


        //recyclerViewNew4

        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)



        val id = intent.getStringExtra("id")

        viewModel.getChaises(id.toString())
        viewModel.myCustomSeats.observe(this, Observer { response ->

            /*  if(response.isSuccessful){
                  textView2.text=response.body().toString()   //Mettre dans adapter: arrayList

              }*/

            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else {
                //textView2.text=response.code().toString()
            }





        })

    }


    private fun saveData() {
        // val insertedText = edtTxtPrenom.text.toString()

        val sharedPreferences = getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("STRING_KEY", idd)
            //putBoolean("BOOLEAN_KEY", sw_switch.isChecked)
        }.apply()
    }

    private fun setupRecyclerview() {
        gridLayoutMananager=GridLayoutManager(applicationContext,2,
            LinearLayoutManager.VERTICAL,false)
        recyclerViewNew4.adapter = myAdapter
        //recyclerView3.layoutManager = LinearLayoutManager(this)
        recyclerViewNew4.layoutManager =gridLayoutMananager
        recyclerViewNew4.setHasFixedSize(true)


    }

}