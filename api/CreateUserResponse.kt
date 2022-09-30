package com.example.retrofitdemo.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CreateUserResponse {
    @SerializedName("data")
    @Expose
    var data: User? =null

    class User {
        @SerializedName("name")
        @Expose
        var name: String?    = null

        @SerializedName("email")
        @Expose
        var email: String?    = null

        @SerializedName("password")
        @Expose
        var password: String? = null

        @SerializedName("confirmPassword")
        @Expose
        var confirmPassword: String? = null

        @SerializedName("token")
        @Expose
        var token: String? = null
    }
}