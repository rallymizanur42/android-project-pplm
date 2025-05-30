package com.ralproject.pplm.tugas5.vPagerFragment.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.ralproject.pplm.R
import com.ralproject.pplm.databinding.FragmentHalamanKeduaBinding

class HalamanKedua : Fragment() {
    private lateinit var binding : FragmentHalamanKeduaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_halaman_kedua, container, false)
        binding = FragmentHalamanKeduaBinding.bind(view)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.txtHalNext.setOnClickListener {
            viewPager?.currentItem = 2
        }
        return view
    }
}