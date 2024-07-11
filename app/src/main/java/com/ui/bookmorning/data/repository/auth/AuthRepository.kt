package com.ui.bookmorning.data.repository.auth

import com.ui.bookmorning.data.datasource.auth.AuthLocalDataSource
import com.ui.bookmorning.data.datasource.auth.AuthRemoteDataSource

class AuthRepository(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) {
    suspend fun login(email: String, password: String): Result<Unit> {
        return authRemoteDataSource.login(
            email = email,
            password = password
        ).map {
            // BE -> Token
            // Android -> Token -> Save to shared Prefs
            authLocalDataSource.saveAccessToken(it.accessToken)
        }
    }

    fun isUserLoggedIn() = authLocalDataSource.isUserLoggedIn()
}