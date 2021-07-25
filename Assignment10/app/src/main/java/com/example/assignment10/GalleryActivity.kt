package com.example.assignment10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment10.databinding.ActivityGalleryBinding
import org.jetbrains.anko.toast

class GalleryActivity : AppCompatActivity() {
    lateinit var binding: ActivityGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        binding = DataBindingUtil.setContentView(this@GalleryActivity, R.layout.activity_gallery)
        val gridLayoutManager = GridLayoutManager(applicationContext, 5)
        gridLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.RecyclerView.layoutManager = gridLayoutManager
        binding.RecyclerView.setHasFixedSize(true)

        if (intent.hasExtra("urlList")) {
            val uriArrayList = intent.getStringArrayListExtra("urlList")
            binding.RecyclerView.adapter = MyAdapter(uriArrayList) }
        else{
            toast("에러!")
        }
    }
}
