package com.example.assignment8_mvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment8_mvvm.R
import com.example.assignment8_mvvm.adapter.ItemAdapter
import com.example.assignment8_mvvm.databinding.ActivityMainBinding
import com.example.assignment8_mvvm.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding:ActivityMainBinding
    private val model : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = model

        mBinding.addButton.setOnClickListener {
            val intent = Intent(this,write_board::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        mBinding.itemRcy.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        mBinding.itemRcy.setHasFixedSize(true)
        model.setItems(mBinding.itemRcy)
    }


}
