package com.ui.bookmorning.data.service

import com.ui.bookmorning.data.cache.KeyValueStorage

class TokenService(
    private val keyValueStorage: KeyValueStorage
) {

    // token = abc
    // token = null
    // token = " "
    // token = "abc"
    var token: String?
        get() = keyValueStorage.get(ACCESS_TOKEN_KEY)
        set(value) {
            if (value.isNullOrBlank()) {
                // Remove Token
                keyValueStorage.remove(ACCESS_TOKEN_KEY)
            } else {
                keyValueStorage.set(key = ACCESS_TOKEN_KEY, value = value)
            }
        }

    companion object {
        private const val ACCESS_TOKEN_KEY = "ACCESS_TOKEN"
    }
}