package com.ralproject.pplm.tugas3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ralproject.pplm.databinding.ActivityConstraintLayoutBinding

class ConstraintLayout : AppCompatActivity() {

    private lateinit var binding : ActivityConstraintLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstraintLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnsimpan.setOnClickListener {
            val hobi = binding.edthobi.text.toString()
            val fav = binding.edtfav.text.toString()

            val massage = "Hobi : $hobi /n Favorite : $fav"

            Toast.makeText(this, massage, Toast.LENGTH_LONG).show()
        }

        binding.btnhapus.setOnClickListener {
            binding.edthobi.text.clear()
            binding.edtfav.text.clear()

            Toast.makeText(this, "Hobi dan Favorite telah dihapus", Toast.LENGTH_LONG).show()
        }

    }
}