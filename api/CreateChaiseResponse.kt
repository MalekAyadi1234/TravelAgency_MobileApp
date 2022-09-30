package com.example.retrofitdemo.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CreateChaiseResponse {
    @SerializedName("data")
    @Expose
    var data: Chaise? =null

    class Chaise {
        @SerializedName("num_chaise")
        @Expose
        var num_chaise: String?    = null

        @SerializedName("disponibilite")
        @Expose
        var disponibilite: Boolean?    = null
    }
}