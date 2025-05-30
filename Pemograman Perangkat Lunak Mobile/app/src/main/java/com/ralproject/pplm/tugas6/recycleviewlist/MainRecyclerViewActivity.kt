package com.ralproject.pplm.tugas6.recycleviewlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ralproject.pplm.databinding.ActivityMainRecyclerViewBinding
import com.ralproject.pplm.tugas6.recycleviewlist.datadanadapter.DekorasiSpasiGambar
import com.ralproject.pplm.tugas6.recycleviewlist.datadanadapter.DosenRecylcerAdapter
import com.ralproject.pplm.tugas6.recycleviewlist.datadanadapter.SumberData

class MainRecyclerViewActivity : AppCompatActivity() {
    private lateinit var dosenAdapter: DosenRecylcerAdapter
    private lateinit var binding: ActivityMainRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        tambahDataSet()
    }
    private fun tambahDataSet() {
        val data = SumberData.buatSetData()
        dosenAdapter.submitList(data)
    }
    private fun initRecyclerView() {
        binding.recylerView.apply {
            layoutManager = LinearLayoutManager( this@MainRecyclerViewActivity)
            val spacingAtas = DekorasiSpasiGambar ( 20)
            addItemDecoration (spacingAtas)
            dosenAdapter = DosenRecylcerAdapter()
            adapter = dosenAdapter
        }
    }
}