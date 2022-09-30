package com.example.retrofitdemo.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemo.MainViewModel
import com.example.retrofitdemo.R
import androidx.lifecycle.Observer
import com.example.retrofitdemo.adapter.MyReservationMaterialAdapter
import com.example.retrofitdemo.adapter.admin.MyrReservationMaterialAdapter
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_passage2.*
import kotlinx.android.synthetic.main.activity_reservation_mat.*

class ReservationMatActivity : AppCompatActivity() {

    private var gridLayoutMananager: GridLayoutManager? = null
    private lateinit var viewModel: MainViewModel
    var date = ""

    private val myAdapter by lazy { MyrReservationMaterialAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation_mat)

        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


        val id = intent.getStringExtra("id")


        viewModel.getCustomMaterials(5, "id", "desc")

        viewModel.myResponse3.observe(this, Observer { response ->

            /*  if(response.isSuccessful){
                  textView2.text=response.body().toString()   //Mettre dans adapter: arrayList

              }*/

            if (response.isSuccessful) {
                response.body()?.let { myAdapter.setData(it) }
            } else {
                //textView2.text=response.code().toString()
            }


        })

    }

    private fun setupRecyclerview() {
        recyclee.adapter = myAdapter
        recyclee.layoutManager = LinearLayoutManager(this)


    }
}

