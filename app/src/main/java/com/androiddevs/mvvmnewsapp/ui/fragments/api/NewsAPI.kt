package com.androiddevs.mvvmnewsapp.ui.fragments.api

import com.androiddevs.mvvmnewsapp.ui.models.NewsResponse
import com.androiddevs.mvvmnewsapp.ui.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//sebuah Endpoint didefinisikan didalam sebuah interface menggunakan Anotasi spesial Retrofit
//untuk melakukan encode detail parameter dan request method.
//Query dapat diartikan sebagai capability (kemampuan) database pada komputer untuk
//uynampilkan/menyimpan informasi tertentu.
interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apikey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        SearchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apikey: String = API_KEY
    ): Response<NewsResponse>
}