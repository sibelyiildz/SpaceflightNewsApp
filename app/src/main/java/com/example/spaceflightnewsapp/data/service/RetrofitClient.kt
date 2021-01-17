package com.example.spaceflightnewsapp.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        val BASE_URL = "https://test.spaceflightnewsapi.net/"

        @Volatile
        private var INSTANCE: Retrofit? = null

        fun getRetrofit(): Retrofit {
            synchronized(this) {
                INSTANCE?.let {
                    return it
                }
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                return INSTANCE as Retrofit

            }
        }

    }
}