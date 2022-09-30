package com.example.retrofitdemo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemo.adapter.MySeatAdapter
import com.example.retrofittest.MainViewModelFactory
import com.example.retrofitdemo.repository.Repository
import kotlinx.android.synthetic.main.activity_main.recyclerView3

class MainActivity2 : AppCompatActivity() {

    private var gridLayoutMananager:GridLayoutManager?=null
    private lateinit var viewModel: MainViewModel
    var idd = ""
    var datedate = ""

    private val myAdapter by lazy { MySeatAdapter(idd,datedate) }

    override fun onCreate(savedInstanceState: Bundle?) {

        val iddd = intent.getStringExtra("id")
        Log.d("yaMallouka ", iddd);
        idd=iddd.toString()


        val daaate = intent.getStringExtra("date")
        Log.d("yaMallouka ", daaate);
        datedate=daaate.toString()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


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

    private fun setupRecyclerview() {
        gridLayoutMananager=GridLayoutManager(applicationContext,2,LinearLayoutManager.VERTICAL,false)
        recyclerView3.adapter = myAdapter
        //recyclerView3.layoutManager = LinearLayoutManager(this)
        recyclerView3.layoutManager =gridLayoutMananager
        recyclerView3.setHasFixedSize(true)


    }

}