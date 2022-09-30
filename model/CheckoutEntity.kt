package com.example.retrofitdemo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CheckoutEntity(
    var seat: String? = "",
    var price: String? = ""
) : Parcelable