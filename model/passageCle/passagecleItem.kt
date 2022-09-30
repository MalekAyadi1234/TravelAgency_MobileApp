package com.example.retrofitdemo.model.passageCle


import com.google.gson.annotations.SerializedName

data class passagecleItem(
    val createdAt: String,
    @SerializedName("date_passage")
    val datePassage: String,
    @SerializedName("_id")
    val id: String,
    val newemail: String,
    val updatedAt: String,
    val userdatas: String,
    @SerializedName("__v")
    val v: Int
)