package com.ui.bookmorning.data.repository.auth

import com.ui.bookmorning.data.datasource.auth.AuthRemoteDataSource
import com.ui.bookmorning.domain.model.auth.LoginModel

class AuthRepository(
    private val authRemoteDataSource: AuthRemoteDataSource
) {

    suspend fun login(email: String, password: String) = authRemoteDataSource.login(email, password)
}