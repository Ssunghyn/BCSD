package com.example.myapplication

import android.app.Activity
import android.content.Context

interface MainContract {
    interface View : BaseView{
        fun showInfo(itemList:ArrayList<Items>)
    }

    interface Presenter : BasePresenter<View>{
        fun setData()
        fun saveData(item:Items,context: Context)
        fun nextActivity(context: Context)
    }
}