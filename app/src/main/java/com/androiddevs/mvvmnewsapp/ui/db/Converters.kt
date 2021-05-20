package com.androiddevs.mvvmnewsapp.ui.db

import androidx.room.TypeConverter
import com.androiddevs.mvvmnewsapp.ui.models.Source


class Converters {
    //Typeconverter ,yang memungkinkan anda untuk mempertahankan tipe costum tertentu kedalam data base
    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}