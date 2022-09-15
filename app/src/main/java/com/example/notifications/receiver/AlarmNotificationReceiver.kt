package com.example.notifications.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.notifications.common.wrappers.NotificationsWrapper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AlarmNotificationReceiver : BroadcastReceiver() {

    @Inject
    lateinit var notificationsWrapper: NotificationsWrapper

    override fun onReceive(context: Context?, intent: Intent?) {
        notificationsWrapper.notify(
            contentTitle = intent?.getStringExtra(NOTIFICATION_TITLE) ?: "Title",
            contentText = intent?.getStringExtra(NOTIFICATION_TEXT) ?: "Content Text"
        )
    }

    companion object {
        const val NOTIFICATION_TITLE = "notification_title"
        const val NOTIFICATION_TEXT = "notification_text"
    }
}
