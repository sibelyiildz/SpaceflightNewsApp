package com.example.spaceflightnewsapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.spaceflightnewsapp.R
import com.example.spaceflightnewsapp.data.model.ArticlesResponse
import com.example.spaceflightnewsapp.data.service.ApiService
import com.example.spaceflightnewsapp.data.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitClient.getRetrofit().create(ApiService::class.java)
        val articlesResponse = service.getArticles()

        articlesResponse.enqueue(object : Callback<List<ArticlesResponse>> {
            override fun onResponse(
                    call: Call<List<ArticlesResponse>>,
                    response: Response<List<ArticlesResponse>>
            ) {
                val articles = response.body()
                Log.e("SUCCESS", articles?.get(0)?.title.toString())
            }

            override fun onFailure(call: Call<List<ArticlesResponse>>, t: Throwable) {
                Log.e("FAILURE", t.message.toString())
            }

        })
    }
}