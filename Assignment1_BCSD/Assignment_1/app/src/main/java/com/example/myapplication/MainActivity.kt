package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var number = 0

        textView.setText(number.toString())

        btn_toast.setOnClickListener {
            Toast.makeText(this@MainActivity,"Toast 메시지가 출력되었습니댜.",Toast.LENGTH_SHORT).show()
        }

        btn_count.setOnClickListener {
            number++
            textView.setText(number.toString())
        }

        btn_random.setOnClickListener {
            val intent =Intent(this,SubActivity::class.java)
            intent.putExtra("countNumber",number)
            startActivity(intent)

        }
    }
}
