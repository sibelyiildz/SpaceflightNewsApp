package com.example.spaceflightnewsapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.spaceflightnewsapp.R
import com.example.spaceflightnewsapp.data.DataSource
import com.example.spaceflightnewsapp.data.Status
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    val dataSource = DataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dataSource.fetchArticle()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                        Log.v("TEST", "LOADING ")

                    }
                    Status.SUCCESS -> {
                        Log.v("TEST", "SUCCESS ")

                    }
                    Status.ERROR -> {
                        Log.v("TEST", "ERROR ")

                    }
                }

            }

    }

}