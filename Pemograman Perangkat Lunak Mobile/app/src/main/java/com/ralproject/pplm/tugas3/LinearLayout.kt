package com.ralproject.pplm.tugas3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ralproject.pplm.databinding.ActivityLinearLayoutBinding

class LinearLayout : AppCompatActivity() {

    private lateinit var binding : ActivityLinearLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLinearLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}