package com.example.notifications.common.wrappers

import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import javax.inject.Inject

class NotificationsWrapper @Inject constructor(
    private val notificationBuilder: NotificationCompat.Builder,
    private val notificationManager: NotificationManagerCompat
) {

    fun notify(contentTitle: String, contentText: String) {
        val notification = notificationBuilder
            .setContentTitle(contentTitle)
            .setContentText(contentText)
            .build()
        notificationManager.notify(1, notification)
    }
}
