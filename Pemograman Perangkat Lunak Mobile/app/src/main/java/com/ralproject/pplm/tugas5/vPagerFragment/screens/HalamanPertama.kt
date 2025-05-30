package com.ralproject.pplm.tugas5.vPagerFragment.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.ralproject.pplm.R
import com.ralproject.pplm.databinding.FragmentHalamanPertamaBinding

class HalamanPertama : Fragment() {
    private lateinit var binding : FragmentHalamanPertamaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_halaman_pertama, container, false)
        binding = FragmentHalamanPertamaBinding.bind(view)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.txtHalNext.setOnClickListener {
            viewPager?.currentItem = 1
        }
        return view
    }
}