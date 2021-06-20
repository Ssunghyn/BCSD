package com.example.assignment6

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaSession2Service
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.LinearLayout
import android.widget.RemoteViews
import android.widget.SeekBar
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var runnable: Runnable
    lateinit var mediaPlayer : MediaPlayer
    private var handler = Handler()
    val CHANNELID = "MusicPlayer"


    override fun onStart() {
        super.onStart()
        play.setOnClickListener {
            if(!mediaPlayer.isPlaying){
                mediaPlayer.start()
                play.setImageResource(R.drawable.ic_baseline_pause_24)
            }else{
                mediaPlayer.pause()
                play.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }

        }

        previous.setOnClickListener {
            seekBar.progress=mediaPlayer.currentPosition-5000
            mediaPlayer.seekTo(seekBar.progress)

        }

        next.setOnClickListener {
            seekBar.progress=mediaPlayer.currentPosition+5000
            mediaPlayer.seekTo(seekBar.progress)

        }

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        runnable = Runnable {
            seekBar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable,1000)

        }
        handler.postDelayed(runnable,1000)

        mediaPlayer.setOnCompletionListener {
            play.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            seekBar.progress=0
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this,R.raw.peaches)
        textView.setText("Peaches")
        mediaPlayer.setVolume(0.5f,0.5f)
        seekBar.progress = 0
        seekBar.max = mediaPlayer.duration

        createNotificationChannel()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        mediaPlayer.release()
        exitProcess(0)
    }

    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Music Player"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNELID, name, importance)

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
        val intent = Intent(this,MainActivity::class.java).apply {
                setAction(Intent.ACTION_MAIN)
                addCategory(Intent.CATEGORY_LAUNCHER)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        val pendingIntent = PendingIntent .getActivity(this, 0, intent,FLAG_UPDATE_CURRENT)

        val notification = NotificationCompat.Builder(this,CHANNELID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Music Player")
            .setContentText("peaches")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(0,notification.build())

    }

}