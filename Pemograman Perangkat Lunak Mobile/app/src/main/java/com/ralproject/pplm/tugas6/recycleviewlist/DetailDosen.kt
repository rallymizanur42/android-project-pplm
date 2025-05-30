package com.ralproject.pplm.tugas6.recycleviewlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ralproject.pplm.R
import com.ralproject.pplm.databinding.DetailDosenBinding

class DetailDosen : AppCompatActivity() {
    private lateinit var binding: DetailDosenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailDosenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (intent.hasExtra ("namanya")) {
            val nama: String = this.intent.getStringExtra( "namanya").toString()
            val foto: String = this.intent.getStringExtra("fotonya").toString()
            val kompetensi: String = this.intent.getStringExtra("kompetensinya").toString()
            val nip: String = this.intent.getStringExtra("nipnya").toString()
            val namaMk: String = this.intent.getStringExtra("namaMknya").toString()
            val ruang: String = this.intent.getStringExtra("ruangnya").toString()
            setDetil(foto, nama, kompetensi, nip, namaMk, ruang)
        }
    }
    fun setDetil(foto: String, nama: String, kompetensi: String, nip: String, namaMk: String,
                 ruang: String) {
        val requestOp = RequestOptions()
        .placeholder (R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
        binding.namaDetilDosen.text = nama
        binding.kompetensi.text = kompetensi
        binding.nip.text = nip
        binding.namaMk.text = namaMk
        binding.ruang.text = ruang
        Glide.with(this)
        .load(foto)
            .apply(requestOp)
            .centerCrop()
            .into(binding.fotoDetil)
    }
}