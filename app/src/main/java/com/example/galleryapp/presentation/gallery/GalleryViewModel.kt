package com.example.galleryapp.presentation.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.data.response.UserImageResponse
import com.example.galleryapp.domain.repositories.GalleryRepository
import kotlinx.coroutines.launch

class GalleryViewModel(private val repository: GalleryRepository):ViewModel() {
    private val _gallery = MutableLiveData<List<UserImageResponse>>()
    val gallery: LiveData<List<UserImageResponse>> = _gallery

    init {
        getPhotoGallery()
    }

    private fun getPhotoGallery(){
        viewModelScope.launch {
            _gallery.postValue(repository.showPhotoList())
        }
    }
}