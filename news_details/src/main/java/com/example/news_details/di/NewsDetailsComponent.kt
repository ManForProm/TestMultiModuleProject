package com.example.news_details

import android.app.Application
import android.content.Context
import com.example.news_api.NewsService
import dagger.Component
import dagger.Module
import javax.inject.Scope

@Component(dependencies = [NewsDetailsDaps::class],
            modules = [NewsDetailsModule::class])
interface NewsDetailsComponent {

    @Component.Builder
    interface Builder{
        fun deps(newsDetailsDaps: NewsDetailsDaps):Builder

        fun build(): NewsDetailsComponent
    }
}

@Module
internal class NewsDetailsModule{

}

interface NewsDetailsDaps{
    val newsService:NewsService
}

interface NewsDetailsDapsProvider{
    val deps:NewsDetailsDaps
}

val Context.newsDetailsDapsProvider:NewsDetailsDapsProvider
    get() = when(this){
        is NewsDetailsDapsProvider -> this
        is Application -> error("Application must implements NewsDetailsDapsProvider")
        else -> applicationContext.newsDetailsDapsProvider

    }

@Scope
internal annotation class NewsDetailScope