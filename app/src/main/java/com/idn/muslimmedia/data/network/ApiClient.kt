package com.idn.muslimmedia.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    fun provideApiService(): ApiService {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor {
                val newRequest = it.request().newBuilder()
                    .addHeader("X-Api-Key", "CHANGE-TO-BE-YOUR-API-KEY")
                    .build()
                it.proceed(newRequest)
            }
            .readTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}