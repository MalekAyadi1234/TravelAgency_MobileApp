package com.example.retrofitdemo.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CreateDelaiRequest {

    @SerializedName("Datenotif")
    @Expose
    var Datenotif: String?    = null

    @SerializedName("delai")
    @Expose
    var delai: String?    = null

    @SerializedName("userdatas")
    @Expose
    var userdatas: String?    = null

    /*

    "userdatas": [
			"61a3cdba5697b6190c1c4ca4"
		]
     */
}