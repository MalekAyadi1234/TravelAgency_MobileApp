package com.example.retrofitdemo.ticket

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.ToolbarConfig
import com.example.retrofitdemo.login.QIBusSoftUISoftUIDashboardActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.activity_detail_ticket.*


class TicketDetailMaterialActivity : AppCompatActivity() {

    lateinit var ivQRxode: ImageView
    lateinit var tvdate:TextView
    lateinit var tvnum:TextView
    lateinit var print:ImageView
    lateinit var btnHome: Button
    lateinit var usertv:TextView




    companion object {
        const val EXTRA_TICKET = "extra_ticket"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_ticket)

        val sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString=sharedPreferences.getString("STRING_KEY",null)

        usertv=findViewById(R.id.textViewseeeeat)
        // putExtra("emaill",strr)
        usertv.text=savedString

        val id_mat = intent.getStringExtra("id")
        val date_mat = intent.getStringExtra("date")
        val name_mat = intent.getStringExtra("name")


        btnHome=findViewById(R.id.button4)
        btnHome.setOnClickListener {
            val intent = Intent(this@TicketDetailMaterialActivity, QIBusSoftUISoftUIDashboardActivity::class.java).apply {
            }
            startActivity(intent)
        }


        print=findViewById(R.id.imageView6)
        print.setOnClickListener {


        }

        tvdate=findViewById(R.id.textViewuserrr)
        tvdate.text=date_mat

        tvnum=findViewById(R.id.textView2)
        tvnum.text=name_mat
        //QR Code

        ivQRxode=findViewById(R.id.ivQRCode)
        var etData="User "+savedString.toString()+"BookingDate"+date_mat.toString()+"&extra"+name_mat.toString()
        Log.d("el QRRRR", etData);




        val data=etData.trim()



        val writer= QRCodeWriter()
        try {

            val bitMatrix=writer.encode(data, BarcodeFormat.QR_CODE,512,512)
            val width=bitMatrix.width
            val height=bitMatrix.height
            val bmp= Bitmap.createBitmap(width,height, Bitmap.Config.RGB_565)
            for (x in 0 until width){
                for (y in 0 until height){

                    bmp.setPixel(x,y,if(bitMatrix[x,y]) Color.BLACK else Color.WHITE)

                }


            }
            ivQRxode.setImageBitmap(bmp)



        }catch (e: WriterException){
            e.printStackTrace()
        }

        //END QR Code

        initToolbar()

        // Parcelable extra from previous activity
        //val movie = intent.getParcelableExtra(EXTRA_TICKET) as MovieEntity

        initView()
    }

    private fun initToolbar() {
        ToolbarConfig.setDefaultStatusBarColor(this)
    }

    private fun initView() {


       /* Glide.with(this)
            .load(movie.poster)
            .into(iv_poster_image)
*/
        iv_back.setOnClickListener {
            finish()
        }

       // dataList.add(CheckoutEntity("A4", ""))
        //dataList.add(CheckoutEntity("C2", ""))

      //  val ticketAdapter = TicketAdapter()

       // ticketAdapter.setTickets(dataList)


    }



}