package com.example.galleryapp.presentation.photo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.data.response.UserImageResponse
import com.example.galleryapp.domain.repositories.GalleryRepository
import kotlinx.coroutines.launch

class PhotoViewModel(private val repository: GalleryRepository):ViewModel() {
   private val _gallery = MutableLiveData<UserImageResponse>()
    val gallery:LiveData<UserImageResponse> = _gallery

    fun showGallery(id:String){
        viewModelScope.launch {
            _gallery.postValue(repository.showPhoto(id))
        }
    }
}