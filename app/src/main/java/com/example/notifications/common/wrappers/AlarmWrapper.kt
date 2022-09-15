package com.example.notifications.common.wrappers

import android.app.AlarmManager
import android.app.PendingIntent
import com.example.notifications.common.annotations.AlarmPendingIntent
import javax.inject.Inject

class AlarmWrapper @Inject constructor(
    private val alarmManager: AlarmManager,
    @AlarmPendingIntent private val alarmPendingIntent: PendingIntent
) {

    fun scheduleAlarm(time: Long) {
        println("SCHEDULE ALARM")
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            time,
            alarmPendingIntent
        )
    }
}
