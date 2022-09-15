package com.example.notifications

import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import com.example.notifications.common.wrappers.AlarmWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.Instant
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val notificationBuilder: NotificationCompat.Builder,
    private val notificationManager: NotificationManagerCompat,
    private val alarmWrapper: AlarmWrapper
) : ViewModel() {

    fun showSimpleNotification() {
        println("SHOW SIMPLE NOTIFICATION")
        val time = Instant.now().plusSeconds(10).toEpochMilli()
        alarmWrapper.scheduleAlarm(time)
    }

    fun updateSimpleNotification() {
        notificationManager.notify(
            1,
            notificationBuilder.setContentTitle("New Title")
                .build()
        )
    }

    fun cancelSimpleNotification() {
        notificationManager.cancel(1)
    }
}
