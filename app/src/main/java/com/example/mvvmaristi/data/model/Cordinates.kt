package com.example.mvvmaristi.data.model

import com.google.gson.annotations.SerializedName

data class Cordinates(
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String
)
