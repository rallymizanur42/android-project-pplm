package com.ralproject.pplm.tugas4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ralproject.pplm.databinding.ActivityKeduaBinding

class ActivityKedua : AppCompatActivity() {

    private lateinit var binding : ActivityKeduaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKeduaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        val value1 = extras!!.getString("Value1")
        val value2 = extras.getString("Value2")
        Toast.makeText(applicationContext, """Value Pertama Adalah : 
            Frist  Value: $value1 
            Value Kedua adalah : $value2""", Toast.LENGTH_LONG).show()
    }

    fun panggilActivityPertama (view: View){
        val i = Intent(applicationContext, ActivityPertama::class.java)
        startActivity(i)
    }
}


