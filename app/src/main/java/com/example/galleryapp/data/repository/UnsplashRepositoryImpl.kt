package com.example.galleryapp.data.repository

import com.example.galleryapp.data.api.UnsplashAPI
import com.example.galleryapp.data.response.UserImageResponse
import com.example.galleryapp.domain.repositories.GalleryRepository

class UnsplashRepositoryImpl(private val unsplashAPI: UnsplashAPI): GalleryRepository {
    override suspend fun showPhotoList(): List<UserImageResponse> = unsplashAPI.getPhotoList()
    override suspend fun showPhoto(id: String): UserImageResponse = unsplashAPI.getPhoto(id)
}