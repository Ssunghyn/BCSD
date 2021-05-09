package com.example.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment.*
import java.util.*

public var number = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textView.setText(number.toString())

        toast.setOnClickListener {
            Toast.makeText(this@MainActivity,"Toast메시지가 출력되었습니다.",Toast.LENGTH_SHORT).show()
        }

        count.setOnClickListener {
            number++;
            textView.setText(number.toString())
        }

        random.setOnClickListener {
            setFrag()
        }


    }

    private fun setFrag() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frame_main,Fragment1()).commit()
    }

}