package com.example.retrofitdemo.admin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemo.MainViewModel
import com.example.retrofitdemo.R
import com.example.retrofitdemo.adapter.admin.GuessAdapter
import androidx.lifecycle.Observer
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_delai2.*
import kotlinx.android.synthetic.main.activity_delai2.recycleDelai
import kotlinx.android.synthetic.main.activity_getwho.*
import kotlinx.android.synthetic.main.activity_main_activity3_admin.*

class getwhoActivity : AppCompatActivity() {
    private var gridLayoutMananager: GridLayoutManager?=null
    private lateinit var viewModel: MainViewModel
    var idd = ""
    var datedate = ""

    private val myAdapter by lazy { GuessAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getwho)
        setupRecyclerview()

       /* val iddd = intent.getStringExtra("idd")
        Log.d("yaMallouka ", idd);
        idd=iddd.toString()

*/

        val sharedPreferences = getSharedPreferences("sharedPrefs2", Context.MODE_PRIVATE)
        val savedString : String? = sharedPreferences.getString("STRING_KEY", null)
        Log.d("yaMalloukalid ", savedString);


        val daaate = intent.getStringExtra("num")
        Log.d("numseat ", daaate);
        //datedate=daaate.toString()





        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)



        val id = intent.getStringExtra("id")

        viewModel.getwhoPosts(savedString.toString(),daaate)
        viewModel.who.observe(this, Observer { response ->

            /*  if(response.isSuccessful){
                  textView2.text=response.body().toString()   //Mettre dans adapter: arrayList

              }*/

            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it)
               // Toast.makeText(this,"good",Toast.LENGTH_LONG).show()
                }
               // textView54.text=response.body().toString()
                //
            }else {
                //textView2.text=response.code().toString()
            }





        })

    }

    private fun setupRecyclerview() {
        pllll.adapter = myAdapter
        pllll.layoutManager = LinearLayoutManager(this)


    }

}