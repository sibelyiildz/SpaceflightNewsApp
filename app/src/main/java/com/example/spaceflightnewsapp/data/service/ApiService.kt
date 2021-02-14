package com.example.spaceflightnewsapp.data.service

import com.example.spaceflightnewsapp.data.model.ArticlesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("/api/v2/articles")
    fun getArticles(): Single<List<ArticlesResponse>>
}