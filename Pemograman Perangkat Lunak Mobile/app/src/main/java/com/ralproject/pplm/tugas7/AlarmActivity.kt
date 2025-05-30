package com.ralproject.pplm.tugas7

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.ralproject.pplm.R
import com.ralproject.pplm.tugas7.utils.AlarmReceiver
import com.ralproject.pplm.tugas7.utils.Constants
import com.ralproject.pplm.tugas7.utils.RandomUtil
import java.text.SimpleDateFormat
import java.util.*

class AlarmActivity : AppCompatActivity() {
    private lateinit var btnSetAlarm: Button
    private lateinit var btnSetRepeatingAlarm: Button
    private lateinit var tvAlarmInfo: TextView
    private lateinit var alarmManager: AlarmManager
    private var calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        initViews()
        initAlarmManager()
        checkNotificationPermission()
    }

    private fun initViews() {
        btnSetAlarm = findViewById(R.id.setAlarmSekarang)
        btnSetRepeatingAlarm = findViewById(R.id.setUlangAlarm)
        btnSetAlarm.setOnClickListener {
            showDateTimePicker(isRepeating = false)
        }

        btnSetRepeatingAlarm.setOnClickListener {
            showDateTimePicker(isRepeating = true)
        }
    }

    private fun initAlarmManager() {
        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    private fun checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                    NOTIFICATION_PERMISSION_CODE
                )
            }
        }
    }

    private fun showDateTimePicker(isRepeating: Boolean) {
        val datePicker = DatePickerDialog(
            this,
            { _, year, month, day ->
                calendar.set(year, month, day)
                showTimePicker(isRepeating)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePicker.show()
    }

    private fun showTimePicker(isRepeating: Boolean) {
        val timePicker = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                calendar.set(Calendar.MINUTE, minute)
                calendar.set(Calendar.SECOND, 0)

                setAlarm(isRepeating)
                showAlarmSetNotification(calendar.timeInMillis, isRepeating)
                updateAlarmInfo(calendar.timeInMillis)
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        )
        timePicker.show()
    }

    private fun setAlarm(isRepeating: Boolean) {
        val intent = Intent(this, AlarmReceiver::class.java).apply {
            action = if (isRepeating) {
                Constants.ACTION_SET_REPETITIVE_EXACT
            } else {
                Constants.ACTION_SET_EXACT
            }
            putExtra(Constants.EXTRA_EXACT_ALARM_TIME, calendar.timeInMillis)
        }

        val pendingIntent = PendingIntent.getBroadcast(
            this,
            RandomUtil.getRandomInt(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        if (isRepeating) {
            alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                AlarmManager.INTERVAL_DAY,
                pendingIntent
            )
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    pendingIntent
                )
            } else {
                alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    pendingIntent
                )
            }
        }
    }

    private fun showAlarmSetNotification(timeInMillis: Long, isRepeating: Boolean) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(notificationManager)

        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        val alarmTime = dateFormat.format(Date(timeInMillis))

        val notification = NotificationCompat.Builder(this, Constants.CHANNEL_ID)
            .setSmallIcon(R.drawable.radio)
            .setContentTitle("Alarm Set")
            .setContentText("Alarm set for: $alarmTime")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("Alarm set for: $alarmTime" + if (isRepeating) " (Repeating)" else ""))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(RandomUtil.getRandomInt(), notification)
    }

    private fun updateAlarmInfo(timeInMillis: Long) {
        val dayFormat = SimpleDateFormat("EEE MMM dd", Locale.getDefault())
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

        tvAlarmInfo.text = "Alarm set for:\n${dayFormat.format(Date(timeInMillis))}\n${timeFormat.format(Date(timeInMillis))}"
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

    companion object {
        private const val NOTIFICATION_PERMISSION_CODE = 1001
    }
}
