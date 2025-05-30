package com.ralproject.pplm.tugas10.datastore

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import com.ralproject.pplm.databinding.ActivityDataStoreBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class DataStoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataStoreBinding
    private lateinit var dataStoreManager: DataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataStoreManager = DataStoreManager(applicationContext)

        binding.btnSimpan.setOnClickListener {
            lifecycleScope.launch {
                val nim = binding.etSimpanNim.text.toString()
                val nama = binding.etSimpanNama.text.toString()

                if (nim.isNotEmpty() && nama.isNotEmpty()) {
                    dataStoreManager.saveData(nim, nama)
                    Toast.makeText(this@DataStoreActivity, "Data tersimpan", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@DataStoreActivity, "NIM dan Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnBaca.setOnClickListener {
            lifecycleScope.launch {
                val nim = binding.etBacaNim.text.toString()
                if (nim.isNotEmpty()) {
                    val nama = dataStoreManager.readData(nim)
                    binding.tvOutput.text = nama ?: "Data tidak ditemukan"
                } else {
                    Toast.makeText(this@DataStoreActivity, "Masukkan NIM yang akan dicari", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}