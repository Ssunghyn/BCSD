package com.example.myapplication

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.Adapter
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_timer.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Timer
import kotlin.concurrent.timer


class Timer : AppCompatActivity() {
    var isWorking : Boolean =false
    @RequiresApi(Build.VERSION_CODES.O)
    var date: LocalDateTime = LocalDateTime.now()
    @RequiresApi(Build.VERSION_CODES.O)
    var strDate = date.format(DateTimeFormatter.ISO_LOCAL_TIME)
    var time = 0
    var timerTask : Timer ?= null
    var itemList = ArrayList<Item>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        start.setOnClickListener {
            if(isWorking==false){
                startTimer()
            }
        }

        stop.setOnClickListener {
            stopTimer()
        }

        pause.setOnClickListener {
            pauseTimer()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun startTimer(){
        timerTask=timer(period = 10){
            time++

            val min = (time/100)/60
            val sec = (time/100)%60
            val milli = time%100
            isWorking=true

            runOnUiThread {
                timeTxt.text="${String.format("%02d",min)}:${String.format("%02d",sec)}:${String.format("%02d",milli)}"
                if(sec%10==0&&time!=0&&milli==0){
                    date = LocalDateTime.now()
                    strDate=date.format(DateTimeFormatter.ISO_LOCAL_TIME)
                    val item = Item(time/100,strDate)
                    itemList.add(item)
                    val Adapter = ItemAdapter(this@Timer,itemList)
                    listView.adapter=Adapter
                }
            }
        }
    }

    private fun stopTimer(){
        timerTask?.cancel()
        time=0
        resetHandler()
        itemList.clear()
        val Adapter= ItemAdapter(this@Timer,itemList)
        listView.adapter=Adapter
        isWorking=false
    }

    private fun pauseTimer() {
        timerTask?.cancel()
        isWorking=false
    }

    private fun resetHandler() {
        val handler:Handler = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                timeTxt.setText("00:00:00")
            }
        }
        handler.obtainMessage().sendToTarget()
    }
}