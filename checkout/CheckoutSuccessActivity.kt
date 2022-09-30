package com.example.retrofitdemo.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitdemo.MainActivity
import com.example.retrofitdemo.R
import com.example.retrofitdemo.ToolbarConfig
import com.example.retrofitdemo.ticket.TicketDetailActivity
import kotlinx.android.synthetic.main.activity_checkout_success.*

class CheckoutSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_success)

        initToolbar()

        btn_home.setOnClickListener {
            finishAffinity()

            val numSeat = intent.getStringExtra("numseat")
            val dateSeance = intent.getStringExtra("dateseance")



            //val dateSeance = intent.getStringExtra("dateseance")
            val intent = Intent(this@CheckoutSuccessActivity, TicketDetailActivity::class.java).apply {
                putExtra("numseatt",numSeat.toString())
                putExtra("dateseancee",dateSeance.toString())

            }
            startActivity(intent)
        }
    }

    private fun initToolbar() {
        ToolbarConfig.setDefaultStatusBarColor(this)
    }
}