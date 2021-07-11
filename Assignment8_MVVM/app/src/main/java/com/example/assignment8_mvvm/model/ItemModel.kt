package com.example.assignment8_mvvm.model

object ItemModel {
    private var itemList = ArrayList<Items>()
    fun getItemList():ArrayList<Items>{
        return itemList
    }

    fun addItemList(items: Items):ArrayList<Items>{
        itemList.add(items)
        return itemList
    }
}