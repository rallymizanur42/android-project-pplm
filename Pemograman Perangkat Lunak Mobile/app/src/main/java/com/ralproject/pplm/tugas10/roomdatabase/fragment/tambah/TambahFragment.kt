package com.ralproject.pplm.tugas10.roomdatabase.fragment.tambah

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ralproject.pplm.R
import com.ralproject.pplm.databinding.FragmentTambahBinding
import com.ralproject.pplm.tugas10.roomdatabase.model.Jadwal
import com.ralproject.pplm.tugas10.roomdatabase.viewmodel.JadwalViewModel

class TambahFragment : Fragment() {
    private var _binding: FragmentTambahBinding? = null
    private val binding get() = _binding!!

    private lateinit var jadwalViewModel: JadwalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTambahBinding.inflate(inflater, container, false)
        val view = binding.root

        jadwalViewModel = ViewModelProvider(this).get(JadwalViewModel::class.java)

        binding.btnTambah.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val hari = binding.etHari.text.toString()
        val jam = binding.etJam.text.toString()
        val menit = binding.etMenit.text.toString()
        val matakuliah = binding.etMatakuliah.text.toString()
        val dosen = binding.etDosen.text.toString()

        if (hari.isNotEmpty() && jam.isNotEmpty() && menit.isNotEmpty() &&
            matakuliah.isNotEmpty() && dosen.isNotEmpty()) {

            val waktu = "$jam:$menit"
            val jadwal = Jadwal(0, hari, waktu, matakuliah, dosen)
            jadwalViewModel.insert(jadwal)
            Toast.makeText(requireContext(), "Berhasil ditambahkan", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_tambahFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Harap isi semua field", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}