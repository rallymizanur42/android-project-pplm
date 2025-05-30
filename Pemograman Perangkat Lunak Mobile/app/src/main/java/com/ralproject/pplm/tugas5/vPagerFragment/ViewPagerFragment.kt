package com.ralproject.pplm.tugas5.vPagerFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ralproject.pplm.R
import com.ralproject.pplm.databinding.FragmentViewPagerBinding
import com.ralproject.pplm.tugas5.vPagerFragment.screens.HalamanKedua
import com.ralproject.pplm.tugas5.vPagerFragment.screens.HalamanKetiga
import com.ralproject.pplm.tugas5.vPagerFragment.screens.HalamanPertama

class ViewPagerFragment : Fragment() {
    lateinit var binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager, container,  false)
        binding = FragmentViewPagerBinding.bind(view)
        val fragmentList = arrayListOf(
            HalamanPertama(),
            HalamanKedua(),
            HalamanKetiga()
        )
        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager,lifecycle)
        binding.viewPager.adapter = adapter
        return view
    }
}
