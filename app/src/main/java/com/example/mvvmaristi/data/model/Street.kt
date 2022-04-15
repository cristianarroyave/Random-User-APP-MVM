package com.example.cleanarchitecture.model

import com.google.gson.annotations.SerializedName

data class Street(
    @SerializedName("number")
    val number: String,
    @SerializedName("name")
    val name: String,
)
