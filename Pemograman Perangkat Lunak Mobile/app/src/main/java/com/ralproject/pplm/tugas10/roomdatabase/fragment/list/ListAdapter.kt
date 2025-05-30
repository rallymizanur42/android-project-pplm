package com.ralproject.pplm.tugas10.roomdatabase.fragment.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ralproject.pplm.databinding.CustomRowBinding
import com.ralproject.pplm.tugas10.roomdatabase.model.Jadwal

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var jadwalList = emptyList<Jadwal>()

    class MyViewHolder(val binding: CustomRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = jadwalList[position]

        holder.binding.tvHari.text = currentItem.hari
        holder.binding.tvWaktu.text = currentItem.waktu
        holder.binding.tvMatakuliah.text = currentItem.matakuliah
        holder.binding.tvDosen.text = currentItem.namaDosen

        holder.binding.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = jadwalList.size

    fun setData(jadwal: List<Jadwal>) {
        this.jadwalList = jadwal
        notifyDataSetChanged()
    }
}
