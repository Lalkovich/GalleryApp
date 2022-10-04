package com.example.galleryapp.data.api

import com.example.galleryapp.BuildConfig
import com.example.galleryapp.data.response.UserImageResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UnsplashAPI {
    @GET("/photos")
   suspend fun getPhotoList(
        @Query("client_id")client_id:String = BuildConfig.UnsplashAPIKey
   ):List<UserImageResponse>

    @GET("/photos/{id}")
    suspend fun getPhoto(
        @Path("id")id:String,
        @Query("client_id")client_id: String = BuildConfig.UnsplashAPIKey
    ): UserImageResponse
}