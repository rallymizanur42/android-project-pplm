package com.ralproject.pplm.tugas5.vPagerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.ralproject.pplm.R
import com.ralproject.pplm.databinding.FragmentHalamanUtamaBinding

class HalamanUtamaFragment : Fragment() {
    private lateinit var binding : FragmentHalamanUtamaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_halaman_utama, container, false)
        binding = FragmentHalamanUtamaBinding.bind(view)
        activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.textUtama.setOnClickListener {
            Toast.makeText(context, "Ini Halaman Home", Toast.LENGTH_LONG).show()
        }
        return view
    }
}