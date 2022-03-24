package com.example.testmultimoduleproject

import android.os.Bundle
import android.os.PersistableBundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.news_details.fragments.ArticleFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val fragmentManager = supportFragmentManager
        if(fragmentManager.findFragmentById(R.id.fragment_container_view_tag) == null){
            fragmentManager.commit {
                add<ArticleFragment>(R.id.fragment_container_view_tag,"articles")
            }
        }
    }
}