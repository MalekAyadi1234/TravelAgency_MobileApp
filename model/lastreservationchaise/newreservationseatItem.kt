package com.example.retrofitdemo.model.lastreservationchaise


import com.google.gson.annotations.SerializedName

data class newreservationseatItem(
    val createdAt: String,
    @SerializedName("_id")
    val id: String,
    val numseat: String,
    val seancedata: List<Seancedata>,
    val updatedAt: String,
    val userdatas: String,
    @SerializedName("__v")
    val v: Int
)