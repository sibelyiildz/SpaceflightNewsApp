package com.example.spaceflightnewsapp.data

import com.example.spaceflightnewsapp.data.model.ArticlesResponse
import com.example.spaceflightnewsapp.data.service.ApiService
import com.example.spaceflightnewsapp.data.service.RetrofitClient
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class DataSource {
    val service = RetrofitClient.getRetrofit().create(ApiService::class.java)
    val articlesResponse = service.getArticles()

    fun fetchArticle(): Observable<Resource<List<ArticlesResponse>>> {
        return Observable.create { emitter ->
            emitter.onNext(Resource.loading())

            articlesResponse
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { articleList ->
                        emitter.onNext(Resource.success(articleList))
                        emitter.onComplete()
                    },
                    { error ->
                        emitter.onNext(Resource.error(error.message ?: ""))
                        emitter.onComplete()
                    }
                )

        }
    }
}