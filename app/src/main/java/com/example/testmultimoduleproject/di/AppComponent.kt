package com.example.testmultimoduleproject.di

import android.app.Application
import com.example.news_api.NewsService
import com.example.news_details.NewsDetailsDaps
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope


@[AppScope Component(modules = [AppModule::class])]
interface AppComponent : NewsDetailsDaps {

    override val newsService:NewsService

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application):Builder

        @BindsInstance
        fun apiKey(@NewsApiQualifier apiKey: String):Builder

        fun build():AppComponent
    }

}

@Module
class AppModule{

    @Provides
    @AppScope
    fun provideNewsService(@NewsApiQualifier apiKey: String):NewsService{
        return NewsService(apiKey)
    }
}

@Qualifier
annotation class NewsApiQualifier

@Scope
annotation class AppScope