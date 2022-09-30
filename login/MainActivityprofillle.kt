package com.example.retrofitdemo.login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemo.MainViewModel
import com.example.retrofitdemo.R
import com.example.retrofitdemo.adapter.MyProfileUserAdapter
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main_activityprofillle.*

class MainActivityprofillle : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyProfileUserAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activityprofillle)
        setupRecyclerview()
        val sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString=sharedPreferences.getString("STRING_KEY",null)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        // viewModel.getCustomPosts(5,"id", "desc")
            viewModel.getuserbyemail("test@esprit.tn")


    }

    private fun setupRecyclerview() {
        recycleprofile.adapter = myAdapter
        recycleprofile.layoutManager = LinearLayoutManager(this)
    }

}