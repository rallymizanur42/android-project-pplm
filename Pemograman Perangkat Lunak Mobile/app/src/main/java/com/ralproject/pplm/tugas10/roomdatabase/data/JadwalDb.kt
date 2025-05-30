package com.ralproject.pplm.tugas10.roomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ralproject.pplm.tugas10.roomdatabase.model.Jadwal

@Database(entities = [Jadwal::class], version = 1, exportSchema = false)
abstract class JadwalDb : RoomDatabase() {
    abstract fun jadwalDao(): JadwalDAO

    companion object {
        @Volatile
        private var INSTANCE: JadwalDb? = null

        fun getDatabase(context: Context): JadwalDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JadwalDb::class.java,
                    "jadwal_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}