package com.example.assignment10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MyAdapter (uriArrayList: ArrayList<String>?):RecyclerView.Adapter<MyAdapter.CustomViewHolder>(){
    private var items = ArrayList<String>()

    init {
        if (uriArrayList != null) {
            this.items=uriArrayList
        }
    }

    class CustomViewHolder (itemView :View):RecyclerView.ViewHolder(itemView){
        val imageView1 = itemView.findViewById<ImageView>(R.id.imageView1).apply {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.CustomViewHolder, position: Int) {
        Glide.with(holder.itemView).load(items[position]).into(holder.imageView1)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}