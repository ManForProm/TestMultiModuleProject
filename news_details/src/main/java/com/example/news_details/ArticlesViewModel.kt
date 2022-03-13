package com.example.news_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_api.Article
import com.example.news_api.NewsService
import kotlinx.coroutines.flow.*

class ArticlesViewModel(private val newsService: NewsService): ViewModel() {

    val newsDetailsComponent: NewsDetailsComponent by lazy{
        DaggerNewsDetailsComponent.builder().build()
    }

    val articles = flow<List<Article>> {
        newsService.topHeadlines().Articles
    }.stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

}