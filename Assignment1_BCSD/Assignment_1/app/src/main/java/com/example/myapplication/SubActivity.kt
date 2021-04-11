package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub2.*
import java.util.*


class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub2)

        if(intent.hasExtra("countNumber")){

            val mainNumber = intent.getIntExtra("countNumber",0)
            textView2.text = "Here is random number between 0 and "+mainNumber.toString()

            val randNum = Random()
            val printNum = randNum.nextInt(mainNumber+1)
            randView.text = printNum.toString()
        }
    }
}