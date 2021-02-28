package com.example.spaceflightnewsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceflightnewsapp.data.model.ArticlesResponse
import com.example.spaceflightnewsapp.data.service.ApiService
import com.example.spaceflightnewsapp.data.service.RetrofitClient
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val service = RetrofitClient.getRetrofit().create(ApiService::class.java)

    private val _articles: MutableLiveData<List<ArticlesResponse>> = MutableLiveData()
    val articles: LiveData<List<ArticlesResponse>> = _articles

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> = _error

    init {
        getArticles()
    }

    private fun getArticles() {
        viewModelScope.launch {
            val response = service.getArticles()
            if (response.isSuccessful) {
                _articles.value = response.body()
            } else {
                _error.value = "Failure ${response.message()}"
            }
        }
    }

}