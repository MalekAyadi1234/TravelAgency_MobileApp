package com.example.retrofitdemo.model.lastreservationchaise


import com.google.gson.annotations.SerializedName

data class Chaise(
    val chaise: String,
    val disponibility: Boolean,
    @SerializedName("_id")
    val id: String
)