package com.example.retrofitdemo.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CreatePassageRequest {

    @SerializedName("newemail")
    @Expose
    var newemail: String?    = null

    @SerializedName("date_passage")
    @Expose
    var date_passage: String?    = null

    @SerializedName("userdatas")
    @Expose
    var userdatas: String?    = null

/*

    userdatas:[{
        type:mongoose.Schema.Types.ObjectId,
        ref:'Utilisateur'
    }],*/

}