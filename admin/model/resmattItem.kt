package com.example.retrofitdemo.admin.model


import com.google.gson.annotations.SerializedName

data class resmattItem(
    val createdAt: String,
    @SerializedName("_id")
    val id: String,
    val materieldata: List<Materieldata>,
    val updatedAt: String,
    val userdatas: String,
    @SerializedName("__v")
    val v: Int
)