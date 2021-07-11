package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(),MainContract.View {

    private lateinit var binding : ActivityMainBinding
    val preseter : MainContract.Presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preseter.takeView(this)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.addButton.setOnClickListener {
            preseter.nextActivity(this)
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        preseter.setData()
    }

    override fun showInfo(itemList: ArrayList<Items>) {
        binding.itemRcy.layoutManager = LinearLayoutManager(MainActivity(),LinearLayoutManager.VERTICAL,false)
        binding.itemRcy.setHasFixedSize(true)
        binding.itemRcy.adapter=ItemAdapter(itemList)
    }


}