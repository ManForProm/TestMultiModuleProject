package com.example.news_details.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.news_details.ArticlesViewModel
import com.example.news_details.R
import com.example.news_details.adapter.ArticleAdapter
import com.example.news_details.databinding.FragmentArticlesBinding
import com.example.news_details.databinding.ItemArticleBinding
import kotlinx.coroutines.flow.collect

/**
 * A fragment representing a list of Items.
 */
class ArticleFragment : Fragment(R.layout.item_article) {



    private val articlesViewModel:ArticlesViewModel by viewModels()
    private var adapter:ArticleAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articleAdapter = ArticleAdapter()
        this.adapter = articleAdapter


        lifecycleScope.launchWhenStarted {
            articlesViewModel.articles.collect{articles ->
                adapter?.submitList(articles)
            }
        }

        val binding = ItemArticleBinding.bind(view)
        with(binding.newsList) {
            layoutManager = LinearLayoutManager(context)
            this.adapter = articleAdapter
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        adapter = null
    }
    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ArticleFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}