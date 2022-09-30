package com.example.retrofitdemo.model


import com.google.gson.annotations.SerializedName

data class PresenceItem(
    val createdAt: String,
    val description: String,
    @SerializedName("_id")
    val id: String,
    val type: String,
    val updatedAt: String,
    @SerializedName("__v")
    val v: Int
)