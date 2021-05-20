package com.androiddevs.mvvmnewsapp.ui.repository

import com.androiddevs.mvvmnewsapp.ui.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.ui.fragments.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.ui.models.Article


//Repository bertanggung jawab untuk semua data yang akan digunakan di aplikasi.
// Mau itu menyimpan data, melakukan update data, menghapus data atau mencari data
// serahkan semuanya kepada Repository
class NewsRepository( val db: ArticleDatabase) {

    //suspend ini adalah cara kotlin menerapkan fungsi yang akan dipanggil dari dalam coroutine
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}