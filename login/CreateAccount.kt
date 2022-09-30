package com.example.retrofitdemo.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.retrofitdemo.R
import com.example.retrofitdemo.api.CreateUserRequest
import com.example.retrofitdemo.api.CreateUserResponse
import com.example.retrofitdemo.api.Retro
import com.example.retrofitdemo.api.SimpleApi


import kotlinx.android.synthetic.main.activity_create_account.*
import retrofit2.Call
import retrofit2.Response

class CreateAccount : AppCompatActivity() {
    lateinit var autoc: AutoCompleteTextView
    lateinit var teacherRB:RadioButton
    lateinit var studentRB:RadioButton
    lateinit var signBtn:ImageView
    lateinit var accountImg:ImageView
    var  path="";
    var rolee="Student";
    companion object{

        val IMAGE_REQUEST_CODE=100


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)


        autoc=findViewById(R.id.classmalek)
        val classes= resources.getStringArray(R.array.classes)
        val arrayAdapter= ArrayAdapter(this,R.layout.dropdown_item,classes)
        autoc.setAdapter(arrayAdapter)

        accountImg=findViewById(R.id.imageView4)
        accountImg.setOnClickListener {
            pickImageGallery()

/* Press Alt + Enter */
        }

        initAction()



    }

    fun initAction() {
        signBtn=findViewById(R.id.buttonSuiv)
        signBtn.setOnClickListener {

            teacherRB=findViewById(R.id.radioButton2)

           /* if (teacherRB.isChecked){
                loginrole.setText("teacher")
            }
            studentRB=findViewById(R.id.radioButton)
            if (studentRB.isChecked){
                loginrole.setText("Student")
            }
            */

            loginclass.setText(autoc.text)
//                tbHideOrNot.setVisibility(View.INVISIBLE);

            val username=namemalek.text.toString().trim()
            val Email= emailmalek.text.toString().trim()
            val phone=phonemalek.text.toString().trim()
            val mdp=newpasswordforget.text.toString().trim()
            val confirmpass=loginconfirmpass.text.toString().trim()
            val classe=loginclass.text.toString().trim()
            val role=rolee.trim()


            if(path.isEmpty()){
               Toast.makeText(this,"You should select an image!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(username.isEmpty()){
                namemalek.error="Username Empty!"
                namemalek.requestFocus()
                return@setOnClickListener
            }

            if(Email.equals("mohamed.hosni@esprit.tn")){
                emailmalek.error="This is an ADMIN Email  !"
                emailmalek.requestFocus()
                return@setOnClickListener
            }

            if(Email.isEmpty() || !Email.contains("@esprit.tn")){
                emailmalek.error="Email Empty Or Should be @esprit.tn !"
                emailmalek.requestFocus()
                return@setOnClickListener
            }





            if(phone.isEmpty()|| phone.length!=8){
                phonemalek.error="Phone Empty Or Should contains 8 numbers!"
                phonemalek.requestFocus()
                return@setOnClickListener
            }

            if(mdp.isEmpty()|| mdp.length<8){
                newpasswordforget.error="Password Empty Or Should Contains 8 characters!"
                newpasswordforget.requestFocus()
                return@setOnClickListener
            }

            if(confirmpass.isEmpty()){
                loginconfirmpass.error="Confirm Password Empty!"
                loginconfirmpass.requestFocus()
                return@setOnClickListener
            }

            if(!confirmpass.equals(mdp)){
                loginconfirmpass.error="Password & Confirm Password should be equal!"
                loginconfirmpass.requestFocus()
                return@setOnClickListener
            }


            if(classe.isEmpty()){
                Toast.makeText(this,"You should select a Class!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
           /* if(role.isEmpty()){
                Toast.makeText(this,"You should select a Role!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }*/
            else
            createAccount()
        }
    }

    fun createAccount() {
        val request = CreateUserRequest()
        request.name = namemalek.text.toString().trim()
        request.email = emailmalek.text.toString().trim()
        request.phone=phonemalek.text.toString().trim()
        request.password= newpasswordforget.text.toString().trim()
        request.confirmPassword= loginconfirmpass.text.toString().trim()
        request.classe=loginclass.text.toString().trim()
        request.role=rolee.toString().trim()
        request.image=path.toString().trim()


        val retro = Retro().getRetroClientInstance().create(SimpleApi::class.java)
        retro.create(request).enqueue(object : retrofit2.Callback<CreateUserResponse> {

            override fun onFailure(call: Call<CreateUserResponse>, t: Throwable) {

                Log.d("auth", "ffff")
                t.message?.let { Log.d("auth", it)
                    initgo()

                }
            }

            override fun onResponse(call: Call<CreateUserResponse>, response: Response<CreateUserResponse>) {


                Log.d("auth", response.code().toString())
                displayError()

            }

        })
    }

    fun initgo() {
        val intent = Intent(this, NewLoginActivity::class.java).apply { }
        startActivity(intent)
        Toast.makeText(applicationContext,"Account Successfully Created",Toast.LENGTH_LONG).show()
    }

    private fun pickImageGallery() {

        val intent =Intent(Intent.ACTION_PICK)
        intent.type="image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)

    }

    fun displayError(){

        Toast.makeText(this,"Email Already Exists!",Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode== RESULT_OK){

            accountImg.setImageURI(data?.data)
            path+=data?.data;
            print(path)


        }
    }
}