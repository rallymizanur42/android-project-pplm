package com.ralproject.pplm.tugas8.services

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class MyIntentService : JobIntentService() {
    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MyIntentService
        var isRunning = false

        fun enqueueWork(context: Context, intent: Intent) {
            enqueueWork(context, MyIntentService::class.java, 1, intent)
            Log.d("MyIntentService", "Servicenya mulai......")
        }

        fun stopService() {
            Log.d("MyIntentService", "Service berhenti")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleWork(intent: Intent) {
        try {
            isRunning = true
            while (isRunning) {
                Log.d("MyIntentService", "Service sedang berjalan")
                Thread.sleep(1000)
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}