package com.example.assignment9.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock.sleep
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.assignment9.R
import com.example.assignment9.databinding.ActivityLoadingBinding
import com.example.assignment9.viewModel.MainViewModel
import kotlin.concurrent.thread

class LoadingActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoadingBinding
    private val model : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        binding  = DataBindingUtil.setContentView(this, R.layout.activity_loading)
        binding.viewModel = model
        val imageView:ImageView = binding.loadingImageView

        Glide.with(this@LoadingActivity)
            .asGif()
            .load("https://img.pikbest.com/58pic/35/39/61/62K58PICb88i68HEwVnm5_PIC2018.gif!bw700")
            .into(imageView)

        thread {
            sleep(5000L)
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}