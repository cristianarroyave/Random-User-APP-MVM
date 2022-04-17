package com.example.mvvmaristi.data.model

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("street")
    val street: Street,
    @SerializedName("city")
    val city: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("postcode")
    val postcode: String,
    @SerializedName("cordinates")
    val cordinates: Cordinates,
    @SerializedName("timezone")
    val timezone: Timezone


)
