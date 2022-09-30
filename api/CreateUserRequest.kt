package com.example.retrofitdemo.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CreateUserRequest {

    @SerializedName("name")
    @Expose
    var name: String?    = null

    @SerializedName("email")
    @Expose
    var email: String?    = null

    @SerializedName("phone")
    @Expose
    var phone: String?    = null

    @SerializedName("password")
    @Expose
    var password: String? = null

    @SerializedName("confirmPassword")
    @Expose
    var confirmPassword: String? = null

    @SerializedName("classe")
    @Expose
    var classe: String?    = null

    @SerializedName("role")
    @Expose
    var role: String?    = null

    @SerializedName("image")
    @Expose
    var image: String?    = null
}