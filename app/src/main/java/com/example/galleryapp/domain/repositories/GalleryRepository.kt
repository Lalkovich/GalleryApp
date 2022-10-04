package com.example.galleryapp.domain.repositories

import com.example.galleryapp.data.response.UserImageResponse

interface GalleryRepository {
    suspend fun showPhotoList():List<UserImageResponse>
    suspend fun showPhoto(id: String): UserImageResponse
}