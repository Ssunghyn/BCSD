package com.example.assignment9.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.example.assignment9.R
import com.example.assignment9.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.menuImageButton.setOnClickListener {
            binding.layoutDraw.openDrawer(GravityCompat.START)
        }
        val navigationView : NavigationView = binding.naviView
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId)
        {
            R.id.list -> {
                Toast.makeText(this,"리스트를 클릭하셨습니다.",Toast.LENGTH_SHORT).show()
            }

            R.id.calculator -> {
                Toast.makeText(this,"계산기를 클릭하셨습니다.",Toast.LENGTH_SHORT).show()
            }

            R.id.timer -> {
                Toast.makeText(this,"타이머를 클릭하셨습니다.",Toast.LENGTH_SHORT).show()
            }

            R.id.camera -> {
                val intent = Intent(this,Camera::class.java)
                startActivity(intent)
            }
        }
        binding.layoutDraw.closeDrawers() //네비게이션 뷰 닫기
        return false
    }

    override fun onBackPressed() {
        if(binding.layoutDraw.isDrawerOpen(GravityCompat.START))
        {
            binding.layoutDraw.closeDrawers()
        }
        else{
            super.onBackPressed()
        }
    }

}




