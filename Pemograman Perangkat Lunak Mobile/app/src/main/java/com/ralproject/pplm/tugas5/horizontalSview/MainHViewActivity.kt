package com.ralproject.pplm.tugas5.horizontalSview

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ralproject.pplm.R
import com.ralproject.pplm.databinding.ActivityMainHviewBinding
import com.ralproject.pplm.databinding.LayoutUtamaBinding

class MainHViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainHviewBinding
    private val menu = arrayOf("Compas", "Bulb", "TV", "Radio", "Tablet", "Book", "Focus", "Global", "Writing", "Video")
    private val gambar = intArrayOf(
        R.drawable.compas, R.drawable.light, R.drawable.tv, R.drawable.radio,
        R.drawable.tablet, R.drawable.book, R.drawable.focus, R.drawable.global,
        R.drawable.writing, R.drawable.video
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inisialisasi binding
        binding = ActivityMainHviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutInflater = LayoutInflater.from(this)
        for (i in menu.indices) {
            val itemBinding = LayoutUtamaBinding.inflate(layoutInflater, binding.linear1, false)

            Glide.with(this)
                .load(gambar[i])
                .override(100, 100)
                .into(itemBinding.iv)
            itemBinding.tv.text = menu[i]

            binding.linear1.addView(itemBinding.root)
        }
    }
}
