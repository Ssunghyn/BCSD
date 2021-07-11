package com.example.assignment8_mvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.assignment8_mvvm.R
import com.example.assignment8_mvvm.databinding.ActivityWriteBoardBinding
import com.example.assignment8_mvvm.model.Items
import com.example.assignment8_mvvm.viewModel.MainViewModel
import java.text.SimpleDateFormat
import java.util.*

class write_board : AppCompatActivity() {

    private lateinit var binding : ActivityWriteBoardBinding
    private val model : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_board)

        val long_now = System.currentTimeMillis()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale("ko","KR"))
        binding = DataBindingUtil.setContentView(this@write_board,R.layout.activity_write_board)
        binding.viewModel = model
        binding.button.setOnClickListener {
            val title = binding.titleEditTxt.text.toString()
            val name = binding.nameEditTxt.text.toString()
            val date = Date(long_now)
            val time = dateFormat.format(date)

            val item = Items(title,name,time)
            model.finishButtonOnclick(item)
            val intent = Intent(this@write_board,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}