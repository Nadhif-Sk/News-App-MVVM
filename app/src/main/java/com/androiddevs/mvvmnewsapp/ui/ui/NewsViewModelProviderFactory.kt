package com.androiddevs.mvvmnewsapp.ui.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.mvvmnewsapp.ui.repository.NewsRepository

class NewsViewModelProviderFactory(
    //ditambahin untuk internet connection -> app: Aplication
    val app: Application,
    val newsRepository: NewsRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //ditambah app -> return NewsViewModel(newsRepository)
        return NewsViewModel(app, newsRepository) as T
    }
}