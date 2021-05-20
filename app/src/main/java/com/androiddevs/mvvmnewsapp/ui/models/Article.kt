package com.androiddevs.mvvmnewsapp.ui.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    //primary key dapat diartikan sebagai kolom yang berisi nilai unik,
    //berfungsi sebagai identitas untuk membedakan setiap record yang ada pada tabel.
    var id: Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
):Serializable

//menserialisasikan penulisan nama variable yang tidak sesuai dengan aturan kotlin