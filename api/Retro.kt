package com.example.retrofitdemo.api

import com.example.retrofittest.utils.Constants.Companion.BASE_URL
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retro {
    fun getRetroClientInstance(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            //.baseUrl("https://backmalek.herokuapp.com/")
            .baseUrl("http://192.168.179.1:3000/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}