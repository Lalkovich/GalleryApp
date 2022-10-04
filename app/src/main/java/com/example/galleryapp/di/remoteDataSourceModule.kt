package com.example.galleryapp.di

import com.example.galleryapp.data.api.UnsplashAPI
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val remoteDataSourceModule = module{

    fun provideHttpClient(): OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
        chain.proceed(
            chain.request().newBuilder().addHeader(
                "authorization",

                ""
            ).build()
        )
    }
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .readTimeout(120, TimeUnit.SECONDS)
        .writeTimeout(120, TimeUnit.SECONDS)
        .connectTimeout(120, TimeUnit.SECONDS)
        .build()

    fun provideGson(): Gson {
        return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }

    fun provideConverterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    fun provideRetrofit(
        httpClient: OkHttpClient,
        callAdapterFactory: CallAdapter.Factory,
        converterFactory: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.unsplash.com")
            .client(httpClient)
            .addCallAdapterFactory(callAdapterFactory)
            .addConverterFactory(converterFactory)
            .build()
    }

    fun provideCallFactory(): CallAdapter.Factory = CoroutineCallAdapterFactory()

    fun provideNewsApi(retrofit: Retrofit): UnsplashAPI {
        return retrofit.create(UnsplashAPI::class.java)
    }

    single{ provideCallFactory() }
    single { provideHttpClient() }
    single { provideGson() }
    single { provideConverterFactory(get()) }
    single { provideRetrofit(get(), get(), get()) }
    single { provideNewsApi(get()) }
}
