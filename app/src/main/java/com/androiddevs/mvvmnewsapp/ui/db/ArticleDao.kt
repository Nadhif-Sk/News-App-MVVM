package com.androiddevs.mvvmnewsapp.ui.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.mvvmnewsapp.ui.models.Article

//untuk mengakses data aplikasi menggunakan library persistensi Room,
//gunakan objek akses data (Data Access Objects) .atau Dao
@Dao
interface ArticleDao {
    //Room akan menghasilkan penerapan yang menyisihkan semua parameter kedatabase dalam satu kali transaksi.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    //DAO .metode inimemungkinkan anda melakukan operasi baca/tulis pada database
    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    //menghapus sekumpulan entitas
    @Delete
    suspend fun deleteArticle(article: Article)

}