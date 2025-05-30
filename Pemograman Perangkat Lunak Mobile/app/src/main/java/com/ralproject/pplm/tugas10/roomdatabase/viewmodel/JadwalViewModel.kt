package com.ralproject.pplm.tugas10.roomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ralproject.pplm.tugas10.roomdatabase.data.JadwalDb
import com.ralproject.pplm.tugas10.roomdatabase.model.Jadwal
import com.ralproject.pplm.tugas10.roomdatabase.repository.JadwalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JadwalViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: JadwalRepository
    val allJadwal: LiveData<List<Jadwal>>

    init {
        val jadwalDao = JadwalDb.getDatabase(application).jadwalDao()
        repository = JadwalRepository(jadwalDao)
        allJadwal = repository.allJadwal
    }

    fun insert(jadwal: Jadwal) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(jadwal)
    }

    fun update(jadwal: Jadwal) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(jadwal)
    }

    fun delete(jadwal: Jadwal) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(jadwal)
    }

    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }
}