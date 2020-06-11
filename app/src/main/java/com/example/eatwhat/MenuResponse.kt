package com.example.eatwhat

import com.google.gson.annotations.SerializedName

data class MenuResponse (
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("selected")
    val selected: Boolean? = null
)
