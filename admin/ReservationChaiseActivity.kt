package com.example.retrofitdemo.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemo.MainViewModel
import com.example.retrofitdemo.R
import com.example.retrofitdemo.adapter.MyReservationChaiseAdapter
import androidx.lifecycle.Observer
import com.example.retrofitdemo.adapter.admin.MySeatAdminAdapter
import com.example.retrofitdemo.adapter.admin.MySeatAdminAdapter2
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_list_seances.*
import kotlinx.android.synthetic.main.activity_reservation_chaise.*
import kotlinx.android.synthetic.main.activity_reservation_mat.*

class ReservationChaiseActivity : AppCompatActivity() {
//recyclerViewadminnnn
private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MySeatAdminAdapter2() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation_chaise)
        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCustomPosts(5,"id", "desc")
        viewModel.myCustomPosts.observe(this, Observer { response ->
            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setupRecyclerview() {
        recyclerViewadminnnn.adapter = myAdapter
        recyclerViewadminnnn.layoutManager = LinearLayoutManager(this)
    }



}