package com.example.galleryapp.app

import android.app.Application
import com.example.galleryapp.di.repositoriesModule
import com.example.galleryapp.di.remoteDataSourceModule
import com.example.galleryapp.di.viewModelsModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class UnsplashApp:Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        initTimber()
    }

    private fun initKoin(){
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@UnsplashApp)
            modules(viewModelsModule, remoteDataSourceModule, repositoriesModule)
        }
    }
    private fun initTimber(){
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}