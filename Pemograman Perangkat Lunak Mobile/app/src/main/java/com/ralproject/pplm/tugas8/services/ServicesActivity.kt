package com.ralproject.pplm.tugas8.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ralproject.pplm.databinding.ActivityServicesBinding


class ServicesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            MyIntentService.enqueueWork(this, Intent())
            binding.txtHasil.text = "Service Jalan"
        }

        binding.btnStop.setOnClickListener {
            MyIntentService.stopService()
            binding.txtHasil.text = "Service Berhenti"
        }
    }
}