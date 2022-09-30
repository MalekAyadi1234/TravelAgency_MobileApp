package com.example.retrofitdemo.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class CreateMatRequest {

    @SerializedName("type")
    @Expose
    var type: String?    = null

    @SerializedName("nom_materiel")
    @Expose
    var nom_materiel: String?    = null

    @SerializedName("date_dispo")
    @Expose
    var date_dispo: Date?    = null


    @SerializedName("heure_debut")
    @Expose
    var heure_debut: String?    = null

    @SerializedName("heure_fin")
    @Expose
    var heure_fin: String?    = null

    @SerializedName("duree")
    @Expose
    var duree: String?    = null

    @SerializedName("image")
    @Expose
    var image: String?    = null

    @SerializedName("disponibilite")
    @Expose
    var disponibilite: String?    = null





    /*

    "userdatas": [
			"61a3cdba5697b6190c1c4ca4"
		]
     */
}