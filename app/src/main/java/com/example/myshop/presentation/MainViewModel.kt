package com.example.myshop.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshop.data.ShopListRepositoryImpl
import com.example.myshop.domain.DeleteShopItemUseCase
import com.example.myshop.domain.EditShopItemUseCase
import com.example.myshop.domain.GetShopListUseCase
import com.example.myshop.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopList(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)

    }

    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }



}