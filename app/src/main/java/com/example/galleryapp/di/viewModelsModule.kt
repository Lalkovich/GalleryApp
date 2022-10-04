package com.example.galleryapp.di

import com.example.galleryapp.presentation.gallery.GalleryViewModel
import com.example.galleryapp.presentation.photo.PhotoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
   viewModel { GalleryViewModel(get()) }
    viewModel { PhotoViewModel(get()) }
}