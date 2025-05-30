package com.ralproject.pplm.tugas3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ralproject.pplm.databinding.ActivityFrameLayoutBinding

class FrameLayout : AppCompatActivity() {

    private lateinit var binding : ActivityFrameLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrameLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClick() {
        binding.btn1.visibility = View.GONE
        binding.text2.visibility = View.VISIBLE
    }
}