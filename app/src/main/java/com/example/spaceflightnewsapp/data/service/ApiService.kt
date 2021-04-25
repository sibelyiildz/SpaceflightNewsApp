package com.example.spaceflightnewsapp.data.service

import com.example.spaceflightnewsapp.data.model.ArticlesResponse
import retrofit2.http.GET

interface ApiService {

    @GET("/api/v2/articles")
    suspend fun getArticles(): List<ArticlesResponse>
}