package com.example.retrofitdemo.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class CreateMatResponse {
    @SerializedName("data")
    @Expose
    var data: Mat? =null

    class Mat {
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
    }
}