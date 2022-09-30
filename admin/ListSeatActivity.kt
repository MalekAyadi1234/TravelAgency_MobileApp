package com.example.retrofitdemo.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemo.MainViewModel
import com.example.retrofitdemo.R
import com.example.retrofitdemo.adapter.MyPresenceAdapter
import com.example.retrofitdemo.adapter.admin.MyChaiseAdminAdapter
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_list_seat.*
import kotlinx.android.synthetic.main.activity_preesence.*
import androidx.lifecycle.Observer

class ListSeatActivity : AppCompatActivity() {
    private var gridLayoutMananager: GridLayoutManager? = null
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyChaiseAdminAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_seat)
        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


        // val id = intent.getStringExtra("id")


        viewModel.getCustomChaisesAdmin(5, "id", "desc")

        viewModel.myCustomChaise.observe(this, Observer { response ->

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
        recyclerviewchaiseadmin.adapter = myAdapter
        recyclerviewchaiseadmin.layoutManager = LinearLayoutManager(this)


    }
}

