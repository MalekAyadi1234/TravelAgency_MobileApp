package com.example.retrofitdemo.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CreateChaiseRequest {

    @SerializedName("num_chaise")
    @Expose
    var num_chaise: String?    = null

    @SerializedName("disponibilite")
    @Expose
    var disponibilite: Boolean?    = null



    /*

    "userdatas": [
			"61a3cdba5697b6190c1c4ca4"
		]
     */
}