package com.ralproject.pplm.tugas4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ralproject.pplm.databinding.ActivityPertamaBinding

class ActivityPertama : AppCompatActivity() {

    private lateinit var binding : ActivityPertamaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPertamaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun panggilActivityKedua (view: View){
        val i = Intent(applicationContext, ActivityKedua::class.java)
        i.putExtra("Value1", "Belajar Android")
        i.putExtra("Value2", "Pemograman Mobile")
        startActivity(i)
    }
}


