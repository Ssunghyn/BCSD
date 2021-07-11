package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager



class MainPresenter:MainContract.Presenter {

    var searchView : MainContract.View ?= null

    override fun setData() {
        val itemList = ItemModel.getItemList()
        searchView?.showInfo(itemList)
    }

    override fun saveData(item:Items,context: Context) {
        ItemModel.addItemList(item)
        val intent = Intent(context,MainActivity::class.java)
        startActivity(context,intent,null)
    }

    override fun nextActivity(context: Context) {
        val intent = Intent(context,write_board::class.java)
        startActivity(context,intent, null)
    }

    override fun takeView(view: MainContract.View) {
        searchView = view
    }
}