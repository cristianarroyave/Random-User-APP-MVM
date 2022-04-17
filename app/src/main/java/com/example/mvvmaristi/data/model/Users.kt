package com.example.mvvmaristi.data.model

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: Name,
    @SerializedName("picture")
    val picture: Picture,
    @SerializedName("registered")
    val registered: Registered,
    @SerializedName("location")
    val location: Location
)