package com.ralproject.pplm.tugas10.roomdatabase.fragment.update

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ralproject.pplm.R
import com.ralproject.pplm.databinding.FragmentTambahBinding
import com.ralproject.pplm.databinding.FragmentUpdateBinding
import com.ralproject.pplm.tugas10.roomdatabase.model.Jadwal
import com.ralproject.pplm.tugas10.roomdatabase.viewmodel.JadwalViewModel


class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()
    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!
    private lateinit var jadwalViewModel: JadwalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        val view = binding.root

        jadwalViewModel = ViewModelProvider(this).get(JadwalViewModel::class.java)

        // Set existing data to EditTexts
        binding.etHari.setText(args.currentJadwal.hari)
        val waktuParts = args.currentJadwal.waktu.split(":")
        binding.etJam.setText(waktuParts[0])
        binding.etMenit.setText(waktuParts[1])
        binding.etMatakuliah.setText(args.currentJadwal.matakuliah)
        binding.etDosen.setText(args.currentJadwal.namaDosen)

        binding.btnUpdate.setOnClickListener {
            updateData()
        }

        setHasOptionsMenu(true)
        return view
    }

    private fun updateData() {
        val hari = binding.etHari.text.toString()
        val jam = binding.etJam.text.toString()
        val menit = binding.etMenit.text.toString()
        val matakuliah = binding.etMatakuliah.text.toString()
        val dosen = binding.etDosen.text.toString()

        if (hari.isNotEmpty() && jam.isNotEmpty() && menit.isNotEmpty() &&
            matakuliah.isNotEmpty() && dosen.isNotEmpty()) {

            val waktu = "$jam:$menit"
            val updatedJadwal = Jadwal(args.currentJadwal.id, hari, waktu, matakuliah, dosen)
            jadwalViewModel.update(updatedJadwal)
            Toast.makeText(requireContext(), "Berhasil diupdate", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Harap isi semua field", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_hapus, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_hapus) {
            deleteJadwal()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteJadwal() {
        jadwalViewModel.delete(args.currentJadwal)
        Toast.makeText(requireContext(), "Berhasil dihapus", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_updateFragment_to_listFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}