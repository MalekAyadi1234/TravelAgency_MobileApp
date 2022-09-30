package com.example.retrofitdemo.model.lastreservationchaise


import com.google.gson.annotations.SerializedName

data class Seancedata(
    val chaises: List<Chaise>,
    val createdAt: String,
    @SerializedName("date_seance")
    val dateSeance: String,
    val duree: Int,
    @SerializedName("heure_debut")
    val heureDebut: String,
    @SerializedName("heure_fin")
    val heureFin: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("num_seance")
    val numSeance: Int,
    val updatedAt: String,
    @SerializedName("__v")
    val v: Int
)