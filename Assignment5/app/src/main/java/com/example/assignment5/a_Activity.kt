package com.example.assignment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_a_.*
import java.util.ArrayList

class a_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a_)

        var list = ArrayList<String>()

        btn_add.setOnClickListener {
            val text = editText.text.toString()
            list.add(text)
            listView.adapter  = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, list)
        }
    }
}