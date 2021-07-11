package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityWriteBoardBinding
import java.text.SimpleDateFormat
import java.util.*

class write_board : AppCompatActivity() {

    private lateinit var binding : ActivityWriteBoardBinding
    val preseter : MainContract.Presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_board)

        val long_now = System.currentTimeMillis()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale("ko","KR"))
        binding = DataBindingUtil.setContentView(this@write_board,R.layout.activity_write_board)

        binding.button.setOnClickListener {
            val title = binding.titleEditTxt.text.toString()
            val name = binding.nameEditTxt.text.toString()
            val date = Date(long_now)
            val time = dateFormat.format(date)

            val item = Items(title,name,time)
            preseter.saveData(item,this@write_board)
            finish()
        }

    }
}