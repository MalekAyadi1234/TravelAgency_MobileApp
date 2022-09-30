package com.example.retrofitdemo.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemo.MainViewModel
import com.example.retrofitdemo.R
import androidx.lifecycle.Observer
import com.example.retrofitdemo.adapter.admin.MyMaterialAdminAdapter
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_list_mat.*

class ListMatActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyMaterialAdminAdapter() }
    private var gridLayoutMananager: GridLayoutManager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_mat)
        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCustomMaterials(5,"id", "desc")
        viewModel.myResponse3.observe(this, Observer { response ->
            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setupRecyclerview() {
        recycleradminMaterial.adapter = myAdapter
        recycleradminMaterial.layoutManager = LinearLayoutManager(this)


    }

}