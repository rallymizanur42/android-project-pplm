package com.ralproject.pplm.tugas10.roomdatabase.fragment.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ralproject.pplm.R
import com.ralproject.pplm.databinding.FragmentListBinding
import com.ralproject.pplm.tugas10.roomdatabase.viewmodel.JadwalViewModel

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var jadwalViewModel: JadwalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = ListAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        jadwalViewModel = ViewModelProvider(this).get(JadwalViewModel::class.java)
        jadwalViewModel.allJadwal.observe(viewLifecycleOwner, { jadwal ->
            adapter.setData(jadwal)
        })

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_tambahFragment)
        }

        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_hapus, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_hapus) {
            jadwalViewModel.deleteAll()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}