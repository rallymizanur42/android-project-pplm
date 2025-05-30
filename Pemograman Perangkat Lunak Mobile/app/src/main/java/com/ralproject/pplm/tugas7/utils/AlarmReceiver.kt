package com.ralproject.pplm.tugas7.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.*

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action ?: return

        if (action != Constants.ACTION_SET_EXACT &&
            action != Constants.ACTION_SET_REPETITIVE_EXACT
        ) return

        val timeInMillis = intent.getLongExtra(Constants.EXTRA_EXACT_ALARM_TIME, 0L)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        val alarmTime = dateFormat.format(Date(timeInMillis))

        showNotification(context, alarmTime)
        showToast(context, alarmTime)
    }

    private fun showNotification(context: Context, alarmTime: String) {
        val notificationManager = ContextCompat.getSystemService(
            context,
            NotificationManager::class.java
        ) as NotificationManager

        createNotificationChannel(notificationManager)

        val notification = NotificationCompat.Builder(context, Constants.CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
            .setContentTitle("Alarm Triggered")
            .setContentText("Alarm at: $alarmTime")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("Alarm triggered at: $alarmTime"))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(RandomUtil.getRandomInt(), notification)
    }

    private fun showToast(context: Context, alarmTime: String) {
        Toast.makeText(context, "Alarm at: $alarmTime", Toast.LENGTH_LONG).show()
    }

    private fun createNotificationChannel(notificationManager: NotificationManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                Constants.CHANNEL_ID,
                "Alarm Notifications",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Channel for alarm notifications"
                enableVibration(true)
            }
            notificationManager.createNotificationChannel(channel)
        }
    }
}
