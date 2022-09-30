package com.example.retrofitdemo.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CreatePassageResponse {
    @SerializedName("data")
    @Expose
    var data: Passage? =null

    class Passage {
        @SerializedName("newemail")
        @Expose
        var newemail: String?    = null

        @SerializedName("date_passage")
        @Expose
        var date_passage: String?    = null
    }
}