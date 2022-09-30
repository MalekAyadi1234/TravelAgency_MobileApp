package com.example.retrofitdemo.model.reservationchaise


import com.google.gson.annotations.SerializedName

data class reservationchaiseItem(
    val createdAt: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("numseat")
    val num: String,
    val seancedata: Seancedata,
    val updatedAt: String,
    val userdatas: String,
    @SerializedName("__v")
    val v: Int
)