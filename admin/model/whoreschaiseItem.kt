package com.example.retrofitdemo.admin.model


import com.google.gson.annotations.SerializedName

data class whoreschaiseItem(
    val createdAt: String,
    @SerializedName("_id")
    val id: String,
    val numseat: String,
    val seancedata: List<String>,
    val updatedAt: String,
    val userdatas: String,
    @SerializedName("__v")
    val v: Int
)