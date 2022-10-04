package com.example.galleryapp.di

import com.example.galleryapp.data.repository.UnsplashRepositoryImpl
import com.example.galleryapp.domain.repositories.GalleryRepository
import org.koin.dsl.module

val repositoriesModule = module{
    single<GalleryRepository>{ UnsplashRepositoryImpl(get()) }
}