package com.example.retrofitdemo.admin

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.retrofitdemo.MainViewModel
import com.example.retrofitdemo.R
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory

class QrscannerActivity : AppCompatActivity() {

    private lateinit var codescanner: CodeScanner
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrscanner)

        if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)==
            PackageManager.PERMISSION_DENIED){

            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),123)

        }else{

            startScanning();
        }

    }

    private fun startScanning() {
        val scannerView:CodeScannerView=findViewById(R.id.scanner_view)
        codescanner= CodeScanner(this,scannerView)
        codescanner.camera=CodeScanner.CAMERA_BACK
        codescanner.formats=CodeScanner.ALL_FORMATS


        codescanner.autoFocusMode=AutoFocusMode.SAFE
        codescanner.scanMode=ScanMode.SINGLE
        codescanner.isAutoFocusEnabled=true
        codescanner.isFlashEnabled=false

        codescanner.decodeCallback= DecodeCallback {
            runOnUiThread {
                Toast.makeText(this,"Scan Result:  ${it.text}",Toast.LENGTH_SHORT).show()
//Ajout Presence
                val repository = Repository()
                val viewModelFactory = MainViewModelFactory(repository)
                viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


                Log.d("seattttttttttttt",it.text)
                if(it.text.contains("trip")){
                    viewModel.addPresence("trip",it.text)

                }

                if(it.text.contains("extra")){
                    viewModel.addPresence("extra",it.text)

                }





                val i= Intent(this,preesenceActivity::class.java)
                startActivity(i)
            }

        }

        codescanner.errorCallback= ErrorCallback {

            runOnUiThread {
                Toast.makeText(this,"Camera init Error:  ${it.message}",Toast.LENGTH_SHORT).show()
            }
        }

        scannerView.setOnClickListener {
            codescanner.startPreview()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode==123){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Camera permission granted",Toast.LENGTH_SHORT).show()
            startScanning()
            }else{
                Toast.makeText(this,"Camera permission denied",Toast.LENGTH_SHORT).show()

            }

        }
    }


    override fun onResume() {
        super.onResume()

        if (::codescanner.isInitialized){
            codescanner?.startPreview()
        }
    }

    override fun onPause() {
if (::codescanner.isInitialized){
    codescanner?.releaseResources()
}
        super.onPause()
    }
}