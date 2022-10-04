package com.example.galleryapp.data.response


import com.google.gson.annotations.SerializedName

data class UserImageResponse(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("urls")
    val urls: Urls,
    @SerializedName("user")
    val user: User,
    @SerializedName("width")
    val width: Int
)