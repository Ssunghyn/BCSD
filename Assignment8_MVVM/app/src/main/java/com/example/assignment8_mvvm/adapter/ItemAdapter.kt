package com.example.assignment8_mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment8_mvvm.R
import com.example.assignment8_mvvm.model.Items

class ItemAdapter(val itemList: ArrayList<Items>) : RecyclerView.Adapter<ItemAdapter.CustomViewHolder>() {
    class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.titleTxt)
        val name = itemView.findViewById<TextView>(R.id.nameTxt)
        val time = itemView.findViewById<TextView>(R.id.timeTxt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos : Int = adapterPosition
                val item : Items = itemList.get(curPos)
                Toast.makeText(parent.context,"제목:${item.title}\n작성자:${item.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: ItemAdapter.CustomViewHolder, position: Int) {
        holder.title.text = itemList.get(position).title
        holder.name.text = itemList.get(position).name
        holder.time.text = itemList.get(position).time
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}