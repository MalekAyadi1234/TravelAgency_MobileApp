package com.example.retrofitdemo.model.delai


import com.google.gson.annotations.SerializedName

data class DelaiItem(
    val createdAt: String,
    @SerializedName("Datenotif")
    val datenotif: String,
    val delai: String,
    @SerializedName("_id")
    val id: String,
    val updatedAt: String,
    val userdatas: String,
    @SerializedName("__v")
    val v: Int
)