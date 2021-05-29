package com.example.assignment5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_Nevi.setOnClickListener {
            layout_draw.openDrawer(GravityCompat.START) //START 왼쪽 , END 오른쪽으로 밀기
        }

        naviView.setNavigationItemSelectedListener(this) //클릭 기능 부여
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean { //네비게이션 메뉴 아이템 클릭시 수행
        when (item.itemId)
        {
            R.id.A -> {
                val intent = Intent(this,a_Activity::class.java)
                startActivity(intent)
            }

            R.id.B -> {
                val intent = Intent(this,b_Activity::class.java)
                startActivity(intent)
            }
        }
        layout_draw.closeDrawers() //네비게이션 뷰 닫기
        return false
    }

    override fun onBackPressed() {
        if(layout_draw.isDrawerOpen(GravityCompat.START))
        {
            layout_draw.closeDrawers()
        }
        else{
        super.onBackPressed()
        }
    }
}