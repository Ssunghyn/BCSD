package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ItemAdapter(val context : Context,val ItemList: ArrayList<Item>):BaseAdapter() {
    override fun getCount(): Int {
        return ItemList.size
    }

    override fun getItem(position: Int): Any {
        return ItemList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View = LayoutInflater.from(context).inflate(R.layout.list_item,null)
        val sec = view.findViewById<TextView>(R.id.second)
        val date = view.findViewById<TextView>(R.id.date)

        val item = ItemList[position]

        sec.text=item.sec.toString()
        date.text=item.date

        return view
    }
}