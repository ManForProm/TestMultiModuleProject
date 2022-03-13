package com.example.news_api

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Articles(
    val Articles:List<Article>
    ){}


/*
"author": "Jeff Somers",
"title": "Is the Crypto Bubble Going to Burst?",
"description": "Even if you aren’t paying attention to Bitcoin and other cryptocurrencies, you might have noticed that their value plummeted last week, with the total value of the market tumbling from a high of $3 trillion last year to about $1.5 trillion in a matter of days…",
"url": "https://lifehacker.com/is-the-crypto-bubble-going-to-burst-1848475768",
"urlToImage": "https://i.kinja-img.com/gawker-media/image/upload/c_fill,f_auto,fl_progressive,g_center,h_675,pg_1,q_80,w_1200/976a59b09e0e681e692bd7517498e3f2.jpg",
"publishedAt": "2022-02-09T16:00:00Z",
"content": "Even if you arent paying attention to Bitcoin and other cryptocurrencies, you might have noticed that their value plummeted last week, with the total value of the market tumbling from a high of $3 tr… [+4782 chars]"
 */

@Serializable
data class Article(
    val author:String,
    val title:String,
    val description:String,
    val url:String,
    val urlToImage:String?,
    @Serializable(with = DateSerializer::class)
    val publishedAt:Date,
    val content:String
) {

}