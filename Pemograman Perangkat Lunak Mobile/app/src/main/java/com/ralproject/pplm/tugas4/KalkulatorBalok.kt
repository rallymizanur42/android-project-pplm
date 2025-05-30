package com.ralproject.pplm.tugas4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ralproject.pplm.R
import com.ralproject.pplm.databinding.ActivityLayoutCalculatorBinding

class KalkulatorBalok : AppCompatActivity() {

    private lateinit var binding : ActivityLayoutCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayoutCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHapus.setOnClickListener {
            binding.edtPanjang.setText("")
            binding.edtTinggi.setText("")
            binding.edtLebar.setText("")
            binding.txHasil.setText(getString(R.string.txt_hasil))
        }

        binding.btnHitung.setOnClickListener {
            val panjang = Integer.valueOf(binding.edtPanjang.getText().toString())
            val tinggi = Integer.valueOf(binding.edtTinggi.getText().toString())
            val lebar = Integer.valueOf(binding.edtLebar.getText().toString())
            val luas = 2 * (panjang * lebar * tinggi)
            val keliling = 4 * (panjang * lebar * tinggi)
            val volume = panjang * lebar * tinggi
            val textOutput = " Hasil Perhitungan \n\nluas : $luas cm" + "\nKeliling : $keliling cm \nVolume : $volume cm"

            binding.txHasil.setText(textOutput)
            binding.txHasil.setTextColor(getColor(R.color.colorAccent))
        }
    }
}