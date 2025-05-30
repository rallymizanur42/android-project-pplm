package com.ralproject.pplm.tugas10.roomdatabase.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "jadwal_kuliah")
data class Jadwal(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val hari: String,
    val waktu: String,
    val matakuliah: String,
    val namaDosen: String
) : Parcelable