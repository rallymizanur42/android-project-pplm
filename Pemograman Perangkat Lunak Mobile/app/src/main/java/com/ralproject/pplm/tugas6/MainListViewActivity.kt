package com.ralproject.pplm.tugas6

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ralproject.pplm.databinding.ActivityMainListViewBinding

class MainListViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainListViewBinding

    val mataPelajaran = arrayOf(
        "Matematika",
        "Pemrograman Mobile",
        "Agama", "Bahasa Inggris",
        "Jaringan Dasar",
        "Pengembangan Game",
        "Animasi",
        "Pemrograman Web",
        "Konsep Teknologi Informasi",
        "Sistem Dperasi",
        "Aljabar Matriks",
        "Pengembangan Game",
        "Animasi",
        "Pemrograman Web",
        "Konsep Teknologi Informasi",
        "Sistem Dperasi",
        "Aljabar Matriks",)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            mataPelajaran
        )
        binding.listview.adapter = arrayAdapter

        binding.listview.setOnItemClickListener { parent, view, posisi, id ->
            Toast.makeText(
                this,
                "Klik pada: " + (posisi + 1) + " " + mataPelajaran[posisi],
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}