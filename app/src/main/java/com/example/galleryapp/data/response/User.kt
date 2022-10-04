package com.example.galleryapp.data.response


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("username")
    val username: String
)