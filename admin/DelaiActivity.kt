package com.example.retrofitdemo.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemo.MainViewModel
import com.example.retrofitdemo.R
import com.example.retrofitdemo.adapter.MyDelaiAdapter
import androidx.lifecycle.Observer
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_delai2.*
import kotlinx.android.synthetic.main.activity_passage2.*

class DelaiActivity : AppCompatActivity() {

    private var gridLayoutMananager: GridLayoutManager? = null
    private lateinit var viewModel: MainViewModel
    var date = ""

    private val myAdapter by lazy { MyDelaiAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delai2)
        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


        val id = intent.getStringExtra("id")


        viewModel.getCustomDelai(5, "id", "desc")

        viewModel.myCustomDelai.observe(this, Observer { response ->

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
        recycleDelai.adapter = myAdapter
        recycleDelai.layoutManager = LinearLayoutManager(this)


    }
}

