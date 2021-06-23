package com.example.retrofitnewsapi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=API_KEY
//https://newsapi.org/v2/everything?domains=wsj.com&apiKey=API_KEY

const val BASE_URl="https://newsapi.org/"
const val API_KEY="44bea2073b3c45848f0f8255a56e113c"
interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
fun getHeadlines(@Query("country")country:String,@Query("page")page:Int):Call<News>

}

object NewsService{
    val newsInstance:NewsInterface
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance=retrofit.create(NewsInterface::class.java)
    }
}