package com.example.assignment8_mvvm.viewModel

import android.app.Application
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment8_mvvm.adapter.ItemAdapter
import com.example.assignment8_mvvm.model.ItemModel
import com.example.assignment8_mvvm.model.Items
import com.example.assignment8_mvvm.view.MainActivity
import com.example.assignment8_mvvm.view.write_board


class MainViewModel() : ViewModel() {

    var itemList = MutableLiveData<ArrayList<Items>>()

    init{
        itemList.value=ItemModel.getItemList()
    }

    fun finishButtonOnclick(items: Items){
        ItemModel.addItemList(items)
    }

    fun setItems(view:RecyclerView){
        val items = ItemModel.getItemList()
        view.adapter = ItemAdapter(items)
        view.adapter?.notifyDataSetChanged()
    }


}