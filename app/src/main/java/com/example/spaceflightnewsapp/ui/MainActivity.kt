package com.example.spaceflightnewsapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.spaceflightnewsapp.R

class MainActivity : AppCompatActivity() {

    private var viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.articles.observe(this) {
            Log.v("TEST", "Success ${it[0].title}")
        }

        viewModel.error.observe(this) {
            Log.v("TEST", " Failure $it")
        }

    }
}