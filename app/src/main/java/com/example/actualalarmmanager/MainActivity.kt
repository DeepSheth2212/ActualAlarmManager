package com.example.actualalarmmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.actualalarmmanager.databinding.ActivityMainBinding
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var alarmItem : AlarmItem? = null
        val scheduler = AndroidAlarmScheduler(this)
        binding.scheduleBtn.setOnClickListener {
            alarmItem = AlarmItem(
                time = LocalDateTime.now().plusSeconds(binding.time.text.toString().toLong()),
                message = binding.message.text.toString()
            )
            alarmItem?.let{scheduler.schedule(it)}
            binding.time.text = null
            binding.message.text = null

        }

            binding.cancelBtn.setOnClickListener {
            alarmItem?.let {
                scheduler.cancelAlarm(it)
            }

                //NOTE - if device reboots the alarm we set gets clear and it doesn't trigger.....in that case we have to reset the alarm when device reboots
        }
    }
}