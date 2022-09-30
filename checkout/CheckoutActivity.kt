package com.example.retrofitdemo.checkout

import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModelProvider

import com.example.retrofitdemo.MainViewModel
import com.example.retrofitdemo.R
import com.example.retrofitdemo.ToolbarConfig
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.activity_checkout.tv_balance
import java.text.NumberFormat
import java.util.*

class CheckoutActivity : AppCompatActivity() {

    //private lateinit var preferences: Preferences
    private lateinit var viewModel: MainViewModel

    lateinit var chosen:TextView
    private var totalTicketPrices: Int = 0
    lateinit var usertv:TextView
    var ism=""


    companion object {
        const val EXTRA_MOVIE_CHECKOUT = "extra_movie_checkout"
        const val EXTRA_CHECKOUT = "extra_checkout"

        const val NOTIFICATION_ID = 1
        const val CHANNEL_ID = "channel_01"
        const val CHANNEL_NAME = "checkout ticket channel"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)


        val sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString=sharedPreferences.getString("STRING_KEY",null)


        usertv=findViewById(R.id.textViewseeeeat)
        // putExtra("emaill",strr)
        usertv.text=savedString
        ism=savedString.toString()

        initToolbar()

        // Initialize Shared Preferences
      //  preferences = Preferences(this)

        // Parcelable extra from previous activity
        //val movie = intent.getParcelableExtra(EXTRA_MOVIE_CHECKOUT) as MovieEntity
       // val dataList = intent.getSerializableExtra(EXTRA_CHECKOUT) as ArrayList<CheckoutEntity>

        initView()
    }

    private fun initToolbar() {
        ToolbarConfig.setDefaultStatusBarColor(this)
    }

    private fun initView() {
        // Insert total prices to recyclerview
       // insertTotalPriceData(dataList)


        val numSeat = intent.getStringExtra("num")
        val idSeance = intent.getStringExtra("idd")
        val idSeat = intent.getStringExtra("id")
        val dateSeance = intent.getStringExtra("dateed")







       // textView24.text=dateSeance

        chosen=findViewById(R.id.chosenseatTV)
        chosen.text=(numSeat)

        iv_back.setOnClickListener {
            finish()
        }

        // Checking balance


        btn_purchase.setOnClickListener {


            val builder = AlertDialog.Builder(this@CheckoutActivity)
            builder.setTitle(getString(R.string.QIBus_softui_text_confirmation))
                .setMessage("Do you want to book this item?")
            builder.setPositiveButton(
                getString(R.string.QIBus_softui_text_yes)
            ) { dialog, id ->

                //Update Statue
                val repository = Repository()
                val viewModelFactory = MainViewModelFactory(repository)
                viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

                // val id = intent.getStringExtra("id")

                viewModel.updateSeatStatue(idSeance,idSeat)
                viewModel.reserveSeat(idSeance,numSeat,ism)

                val intent = Intent(this@CheckoutActivity, CheckoutSuccessActivity::class.java).apply {
                    putExtra("numseat",numSeat.toString())
                    putExtra("dateseance",dateSeance.toString())

                }
                startActivity(intent)

                showTicketPurchasedNotification()


            }
            builder.setNegativeButton(
                getString(R.string.QIBus_softui_text_no)
            ) { dialog, id -> dialog.cancel() }
            val alert = builder.create()
            alert.show()

            /*//Update Statue
            val repository = Repository()
            val viewModelFactory = MainViewModelFactory(repository)
            viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

            // val id = intent.getStringExtra("id")

            viewModel.updateSeatStatue(idSeance,idSeat)
            viewModel.reserveSeat(idSeance,numSeat,ism)

            val intent = Intent(this@CheckoutActivity, CheckoutSuccessActivity::class.java).apply {
                putExtra("numseat",numSeat.toString())
                putExtra("dateseance",dateSeance.toString())

            }
            startActivity(intent)

            showTicketPurchasedNotification()

            */





        }

        btn_cancel_purchase.setOnClickListener {






            finish()
        }
    }



    private fun convertCurrencyBalance(balance: Double) {
        val localeID = Locale("in", "ID")
        val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
        tv_balance.text = (formatRupiah.format(balance))
    }

    private fun showTicketPurchasedNotification() {
        val mNotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Notification click
        val intent = Intent(this, CheckoutSuccessActivity::class.java)
        val pendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        // Notification builder
        val mBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.logo_mov)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher_round))
            .setContentTitle(resources.getString(R.string.content_title))
            .setContentText("Seat Successfully Booked!")
            .setAutoCancel(true)

        /*
            For android Oreos and above it is necessary to add a notification channel
        */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = CHANNEL_NAME
            mBuilder.setChannelId(CHANNEL_ID)
            mNotificationManager.createNotificationChannel(channel)
        }

        val notification = mBuilder.build()

        mNotificationManager.notify(NOTIFICATION_ID, notification)
    }
}