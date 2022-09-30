package com.example.retrofitdemo.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRequest {
    @SerializedName("email")
    @Expose
    var email: String?    = null

    @SerializedName("password")
    @Expose
    var password: String? = null
}