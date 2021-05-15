package com.example.assignment4

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

var number = 0;
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.setText(number.toString())

        dialog.setOnClickListener {
            showDialog()
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
        ft.addToBackStack(null)
    }

    private fun showDialog(){
        val dig: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity,android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth)
        dig.setTitle("선택하세요!")
        dig.setMessage("COUNT를 초기화 하고 싶으면 positive, toast메세지를 띄우고 싶으면 neutral, 알림을 끄고 싶으면 negative를 누르세요.")
        dig.setPositiveButton("positive",DialogInterface.OnClickListener { dialog, which ->
            number=0
            textView.setText(number.toString())

        })
        dig.setNeutralButton("neutral",DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(this@MainActivity,"Toast메세지입니다.",Toast.LENGTH_SHORT).show()

        })
        dig.setNegativeButton("negative",DialogInterface.OnClickListener { dialog, which ->

        })
        dig.show()
    }
}