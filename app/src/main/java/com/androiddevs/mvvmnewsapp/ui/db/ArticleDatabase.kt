package com.androiddevs.mvvmnewsapp.ui.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.androiddevs.mvvmnewsapp.ui.models.Article


@Database(
    entities = [Article::class],
    version = 1
)

//jika anda meltakan nya di database ,semua Dao dan Entitas dalam database itu akan dapat menggunakanya.
//saat anda harus menyimpaan dalam database beberapa tipe custom ,anda bisa menggunakan Type Converters.
@TypeConverters(Converters::class)
abstract class ArticleDatabase :RoomDatabase() {
    //abstract class adalah kelas yang tidak utuh atau tidak berguna tanpa adanya
//subclass yang konkrit ,yang bisa dipakai untuk membuat
//objectclass ini digunakan untuk membuat object dari room database itu sendiri,
//didalamnya terdapat class-class DAO yang akan digunakan.

    abstract fun getArticleDao(): ArticleDao

    //jadi,dengan mendeklarasikan companion object ,kita bisa mengakses member dari suatu kelas tanpa melalui object
    companion object{
        @Volatile
        // volatile merupakan salah satu jenis keyword yang terdapat di bahasa pemrograman java ,
// yang dimana fungsinya untuk mencegah thread , menyembunyikan (caching) nilai pada variable.
// Keyword ini digunakan untuk menandai suatu variable ,yang disimpan di memori utama.
        private var instance: ArticleDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also{ instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()
    }
}