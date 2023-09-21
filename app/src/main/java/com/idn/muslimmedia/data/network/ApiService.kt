package com.idn.muslimmedia.data.network

import com.idn.muslimmedia.data.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v2/everything")
    fun getCommonMuslimNews(
        @Query("q") q: String = "islam",
        @Query("language") language: String = "en",
        @Query("pageSize") pageSize: Int = 50,
        @Query("sortBy") sortBy: String = "popularity"
    ): Call<NewsResponse>

    @GET("/v2/everything")
    fun getAlQuranNews(
        @Query("q") q: String = "Al-quran",
        @Query("language") language: String = "en"
    ): Call<NewsResponse>

    @GET("/v2/top-headlines")
    fun getAlJazeeraNews(
        @Query("sources") sources: String = "al-jazeera-english"
    ): Call<NewsResponse>

    @GET("/v2/everything")
    fun getWarningForMuslimNews(
        @Query("q") q: String = "anti islam",
        @Query("language") language: String = "en"
    ): Call<NewsResponse>

    @GET("/v2/everything")
    fun getSearchNews(
        @Query("q") q: String,
        @Query("pageSize") pageSize: Int = 19,
    ): Call<NewsResponse>
}