package com.example.spaceflightnewsapp.data.service

import com.example.spaceflightnewsapp.data.model.ArticlesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/api/v2/articles")
    fun getArticles(): Call<List<ArticlesResponse>>
}