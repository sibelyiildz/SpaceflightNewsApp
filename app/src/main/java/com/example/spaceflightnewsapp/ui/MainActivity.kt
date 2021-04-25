package com.example.spaceflightnewsapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.spaceflightnewsapp.R
import com.example.spaceflightnewsapp.util.Status

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getArticle().observe(this, Observer { state ->
            when (state.status) {
                Status.LOADING -> {
                    Log.e("TEST", "LOADING ${state.data}")
                }
                Status.SUCCESS -> {
                    Log.e("TEST", "SUCCESS ${state.data}")
                }
                Status.ERROR -> {
                    Log.e("TEST", "ERROR ${state.data}")
                }
            }
        })

    }
}