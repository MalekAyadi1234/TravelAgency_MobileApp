package com.example.retrofitdemo.admin.model


import com.google.gson.annotations.SerializedName

data class Materieldata(
    val createdAt: String,
    @SerializedName("date_dispo")
    val dateDispo: String,
    val disponibilite: Boolean,
    val duree: String,
    @SerializedName("heure_debut")
    val heureDebut: String,
    @SerializedName("heure_fin")
    val heureFin: String,
    @SerializedName("_id")
    val id: String,
    val image: String,
    @SerializedName("nom_materiel")
    val nomMateriel: String,
    val type: String,
    val updatedAt: String,
    @SerializedName("__v")
    val v: Int
)