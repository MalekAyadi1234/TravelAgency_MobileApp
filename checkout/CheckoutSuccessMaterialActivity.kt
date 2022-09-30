package com.example.retrofitdemo.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitdemo.MainActivity
import com.example.retrofitdemo.R
import com.example.retrofitdemo.ToolbarConfig
import com.example.retrofitdemo.ticket.TicketDetailActivity
import com.example.retrofitdemo.ticket.TicketDetailMaterialActivity
import kotlinx.android.synthetic.main.activity_checkout_success.*

class CheckoutSuccessMaterialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_success_material)

        initToolbar()

        btn_home.setOnClickListener {
            finishAffinity()

            val id_mat = intent.getStringExtra("id")
            val date_mat = intent.getStringExtra("date")
            val name_mat = intent.getStringExtra("name")

            val intent = Intent(this@CheckoutSuccessMaterialActivity, TicketDetailMaterialActivity::class.java).apply {
                putExtra("id", id_mat.toString())
                putExtra("date", date_mat.toString())
                putExtra("name", name_mat.toString())

            }
            startActivity(intent)
        }
    }

    private fun initToolbar() {
        ToolbarConfig.setDefaultStatusBarColor(this)
    }
}