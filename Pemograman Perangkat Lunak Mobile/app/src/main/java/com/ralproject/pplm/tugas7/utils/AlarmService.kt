package com.ralproject.pplm.tugas7.utils

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder

class AlarmService : Service() {
    private lateinit var alarmManager: AlarmManager

    override fun onCreate() {
        super.onCreate()
        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    override fun onBind(intent: Intent?): IBinder? = null

    fun setAlarmSekarang(timeInMillis: Long) {
        setAlarm(
            timeInMillis,
            getPendingIntent(
                getIntent().apply {
                    action = Constants.ACTION_SET_EXACT
                    putExtra(Constants.EXTRA_EXACT_ALARM_TIME, timeInMillis)
                }
            )
        )
    }

    fun setAlarmBerulang(timeInMillis: Long) {
        setAlarm(
            timeInMillis,
            getPendingIntent(
                getIntent().apply {
                    action = Constants.ACTION_SET_REPETITIVE_EXACT
                    putExtra(Constants.EXTRA_EXACT_ALARM_TIME, timeInMillis)
                }
            )
        )
    }

    private fun getIntent() = Intent(this, AlarmReceiver::class.java)

    private fun getPendingIntent(intent: Intent): PendingIntent =
        PendingIntent.getBroadcast(
            this,
            RandomUtil.getRandomInt(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

    private fun setAlarm(timeInMillis: Long, pendingIntent: PendingIntent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (alarmManager.canScheduleExactAlarms()) {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    timeInMillis,
                    pendingIntent
                )
            }
        } else {
            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                timeInMillis,
                pendingIntent
            )
        }
    }
}
