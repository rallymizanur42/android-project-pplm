package com.ralproject.pplm.tugas10.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ralproject.pplm.tugas10.roomdatabase.model.Jadwal

@Dao
interface JadwalDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(jadwal: Jadwal)

    @Update
    suspend fun update(jadwal: Jadwal)

    @Delete
    suspend fun delete(jadwal: Jadwal)

    @Query("SELECT * FROM jadwal_kuliah ORDER BY id ASC")
    fun getAllJadwal(): LiveData<List<Jadwal>>

    @Query("DELETE FROM jadwal_kuliah")
    suspend fun deleteAll()
}