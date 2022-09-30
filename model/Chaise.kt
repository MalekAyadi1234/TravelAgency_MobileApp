package com.example.retrofitdemo.model


import com.google.gson.annotations.SerializedName

data class Chaise(
    val disponibilite: Boolean,
    @SerializedName("_id")
    val id: String,
    @SerializedName("num_chaise")
    val numChaise: String
)