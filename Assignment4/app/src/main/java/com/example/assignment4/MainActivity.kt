package com.example.assignment4

import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

var number = 0

class MainActivity : AppCompatActivity() {
    val CHANNEL_ID = "channelID"
    var progressMax = 100


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
            start(progressMax)
        }
    }
    fun setFrag() {
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
        dig.setNegativeButton("negative",DialogInterface.OnClickListener { dialog, which ->        })
        dig.show()
    }

    fun start(progressNum:Int){
        val intent = Intent(this,MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent:PendingIntent = PendingIntent.getActivity(this,0,intent,0)
        val notification = NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Progressbar")
                .setContentText("Loading...")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setOngoing(true)
                .setProgress(progressNum,0,true)
                .setContentIntent(pendingIntent)
        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(0,notification.build())

        if(progressNum==0) {
            notification.setContentText("Finish")
                    .setProgress(progressNum, 0, false)
                    .setOngoing(false)
            notificationManager.notify(0, notification.build())
            exitProcess(0)
        }
    }
}
