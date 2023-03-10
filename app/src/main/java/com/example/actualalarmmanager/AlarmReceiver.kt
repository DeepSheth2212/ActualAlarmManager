package com.example.actualalarmmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat

class AlarmReceiver : BroadcastReceiver() {
    private val CHANNEL_ID = "channelID"
    private val NOTIFICATION_ID = 100
    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent?.getStringExtra("EXTRA_MSG") ?: return
//        println("Alarm triggered!: $message")
        Log.d("Alarm","Alarm triggered with message : $message")
        context?.let {
            val notificationManager = context.getSystemService(NotificationManager::class.java)
            val notification =
                NotificationCompat.Builder(context).setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentText("Wake up!").setContentTitle("AlarmManager")
                    .setChannelId(CHANNEL_ID)
                    .build()
            notificationManager.createNotificationChannel(
                NotificationChannel(
                    CHANNEL_ID,
                    "ChannelName",
                    NotificationManager.IMPORTANCE_HIGH
                )
            )
            notificationManager.notify(NOTIFICATION_ID,notification)
        }



    }
}