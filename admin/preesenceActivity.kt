package com.example.retrofitdemo.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemo.MainViewModel
import com.example.retrofitdemo.R
import androidx.lifecycle.Observer
import com.example.retrofitdemo.adapter.MyPresenceAdapter
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_preesence.*

class preesenceActivity : AppCompatActivity() {

    private var gridLayoutMananager: GridLayoutManager? = null
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyPresenceAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preesence)
        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


       // val id = intent.getStringExtra("id")


        viewModel.getCustomPresence(5, "id", "desc")

        viewModel.myCustomPresence.observe(this, Observer { response ->

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
        recyclerPresence.adapter = myAdapter
        recyclerPresence.layoutManager = LinearLayoutManager(this)


    }
}

