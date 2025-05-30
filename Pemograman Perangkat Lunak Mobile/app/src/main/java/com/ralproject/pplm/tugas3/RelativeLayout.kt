package com.ralproject.pplm.tugas3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ralproject.pplm.databinding.ActivityRelativeLayoutBinding

class RelativeLayout : AppCompatActivity() {

    private lateinit var binding : ActivityRelativeLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRelativeLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}


