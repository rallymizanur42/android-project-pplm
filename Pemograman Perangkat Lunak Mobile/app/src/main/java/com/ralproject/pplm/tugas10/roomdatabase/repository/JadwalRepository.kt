package com.ralproject.pplm.tugas10.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.ralproject.pplm.tugas10.roomdatabase.data.JadwalDAO
import com.ralproject.pplm.tugas10.roomdatabase.model.Jadwal


class JadwalRepository(private val jadwalDao: JadwalDAO) {
    val allJadwal: LiveData<List<Jadwal>> = jadwalDao.getAllJadwal()

    suspend fun insert(jadwal: Jadwal) {
        jadwalDao.insert(jadwal)
    }

    suspend fun update(jadwal: Jadwal) {
        jadwalDao.update(jadwal)
    }

    suspend fun delete(jadwal: Jadwal) {
        jadwalDao.delete(jadwal)
    }

    suspend fun deleteAll() {
        jadwalDao.deleteAll()
    }
}