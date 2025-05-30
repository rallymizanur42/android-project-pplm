package com.ralproject.pplm.tugas4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ralproject.pplm.databinding.ActivityTableLayoutModifBinding

class CustomTable : AppCompatActivity() {

    private lateinit var binding : ActivityTableLayoutModifBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTableLayoutModifBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}


