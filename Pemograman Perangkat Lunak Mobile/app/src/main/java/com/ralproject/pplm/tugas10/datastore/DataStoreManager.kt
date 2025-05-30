package com.ralproject.pplm.tugas10.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.first
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class DataStoreManager(context: Context) {
    private val dataStore = context.dataStore

    suspend fun saveData(key: String, value: String) {
        dataStore.edit { preferences ->
            preferences[stringPreferencesKey(key)] = value
        }
    }

    suspend fun readData(key: String): String? {
        val preferences = dataStore.data.first()
        return preferences[stringPreferencesKey(key)]
    }
}