package com.example.myshop.di

import android.app.Application
import com.example.myshop.data.AppDatabase
import com.example.myshop.data.ShopItemDao
import com.example.myshop.data.ShopListRepositoryImpl
import com.example.myshop.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object{
        @ApplicationScope
        @Provides
        fun provideShopItemDao(application: Application): ShopItemDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}