package com.example.myapplication

import android.content.Context
import androidx.databinding.DataBindingUtil
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

var itemlist = ArrayList<Items>()

object ItemModel {
    fun getItemList() : ArrayList<Items>{
        return itemlist
    }

    fun addItemList (item:Items) : ArrayList<Items>{
        itemlist.add(item)
        return itemlist
    }
}