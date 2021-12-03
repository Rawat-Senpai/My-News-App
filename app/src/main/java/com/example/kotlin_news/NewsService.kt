package com.example.kotlin_news

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//  https://newsapi.org/v2/top-headlines?country=in&apiKey=4e52161a5f7040218160bef6d15b75c0
//  https://newsapi.org/v2/everything?q=BSF&from=2021-11-02&sortBy=publishedAt&apiKey=4e52161a5f7040218160bef6d15b75c0

const val Base_url= "https://newsapi.org/v2/"
const val  Api_key ="4e52161a5f7040218160bef6d15b75c0"


//https://newsapi.org/v2/top-headlines?apiKey=
interface  NewsInterface {
    @GET("top-headlines?apiKey=$Api_key")
    fun getHeadLines(@Query("country")country:String,@Query("category")category:String,@Query("page")page:Int):Call<News>

}

//interface  TechNews{
//    @GET("top-headlines?apiKey=$Api_key")
//    fun getHeadLines(@Query("country")country:String,@Query("page")page:Int):Call<News>
//
//}

object  NewsService{
    val newsInstance: NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance= retrofit.create(NewsInterface::class.java)
    }

}