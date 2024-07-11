package com.ui.bookmorning.data.cache

import android.content.SharedPreferences
import com.tencent.mmkv.MMKV

interface KeyValueStorage {
    fun get(key: String): String?
    fun set(key: String, value: String)
    fun remove(key: String)
}

class SharedPrefStorage(
    private val sharedPreferences: SharedPreferences
) : KeyValueStorage {
    // Get
    override fun get(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    // Set
    override fun set(key: String, value: String) {
        // Main Thread
        sharedPreferences.edit().apply {
            putString(key, value)
            apply() // Commit
        }
    }

    // remove
    override fun remove(key: String) {
        sharedPreferences.edit().apply {
            remove(key)
            apply() // Commit
        }
    }
}

class MMKVPrefStorage(
    private val mmKV: MMKV
) : KeyValueStorage {

    override fun get(key: String): String? {
        return mmKV.decodeString(key)
    }

    // Set
    override fun set(key: String, value: String) {
        mmKV.encode(key, value)
    }

    // remove
    override fun remove(key: String) {
        mmKV.remove(key)
    }
}