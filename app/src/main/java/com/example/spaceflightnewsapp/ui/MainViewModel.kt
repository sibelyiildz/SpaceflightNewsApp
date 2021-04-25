package com.example.spaceflightnewsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.spaceflightnewsapp.data.service.ApiService
import com.example.spaceflightnewsapp.data.service.RetrofitClient
import com.example.spaceflightnewsapp.util.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    private val service = RetrofitClient.getRetrofit().create(ApiService::class.java)

    fun getArticle() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(service.getArticles()))
        } catch (exception: Exception) {
            emit(Resource.error(null, exception.message ?: "Failure!"))
        }
    }

}