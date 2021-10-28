package com.example.myshop.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.myshop.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this){
            Log.d("MainActivityTest", it.toString())
            val item = it[0]
            if (count == 0) {
                viewModel.deleteShopList(item)
                count++
            }
        }

    }
}