package com.ralproject.pplm.tugas8.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ralproject.pplm.databinding.ActivityCoroutineBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoroutineBinding
    private val HASIL_1 = "Hasil #1"
    private val HASIL_2 = "Hasil #2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKlik.setOnClickListener {
            CoroutineScope(IO).launch {
                reqDataAPI()
            }
        }
    }

    private suspend fun contohReqDataDariNetwork(): String {
        logThread("contohReqDataDariNetwork")
        delay(1000)
        return HASIL_1
    }

    private suspend fun contohReqDataDariNetwork2(): String {
        logThread("contohReqDataDariNetwork")
        delay(1000)
        return HASIL_2
    }

    private fun setTeks(input: String) {
        val teks = binding.txtHasil.text.toString() + "\n$input"
        binding.txtHasil.text = teks
    }

    private suspend fun setTeksPadaMainThread(input: String) {
        withContext(Main) {
            setTeks(input)
        }
    }

    private suspend fun reqDataAPI() {
        val hasil = contohReqDataDariNetwork()
        println("debug: $hasil")
        setTeksPadaMainThread(hasil)

        val hasil2 = contohReqDataDariNetwork2()
        println("debug: $hasil2")
        setTeksPadaMainThread(hasil2)
    }

    private fun logThread(methodName: String) {
        println("debug: $methodName: ${Thread.currentThread().name}")
    }
}