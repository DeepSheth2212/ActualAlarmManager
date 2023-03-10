package com.example.actualalarmmanager

interface AlarmScheduler {
    fun schedule(item: AlarmItem)
    fun cancelAlarm(item: AlarmItem)
}