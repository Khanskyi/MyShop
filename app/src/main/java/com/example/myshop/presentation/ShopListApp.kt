package com.example.myshop.presentation

import android.app.Application
import com.example.myshop.di.DaggerApplicationComponent

class ShoppingListApp: Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}