package com.example.testmultimoduleproject

import android.app.Application
import com.example.news_details.NewsDetailsDaps
import com.example.news_details.NewsDetailsDapsProvider
import com.example.testmultimoduleproject.di.AppComponent
import com.example.testmultimoduleproject.di.DaggerAppComponent
import dagger.internal.DaggerCollections

class NewsApp:Application(), NewsDetailsDapsProvider {

    val appComponent:AppComponent by lazy{
        DaggerAppComponent.builder()
            .application(this)
            .apiKey(BuildConfig.NEWS_API_KEY)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

    override val deps: NewsDetailsDaps = appComponent
}