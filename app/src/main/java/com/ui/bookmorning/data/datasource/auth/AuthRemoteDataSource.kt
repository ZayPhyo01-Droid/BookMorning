package com.ui.bookmorning.data.datasource.auth

import com.ui.bookmorning.data.model.request.LoginRequest
import com.ui.bookmorning.data.service.AuthService
import com.ui.bookmorning.domain.model.auth.LoginModel
import kotlinx.coroutines.delay

class AuthRemoteDataSource(
    private val authService: AuthService
) {
    suspend fun login(email: String, password: String): Result<LoginModel> {
        return authService.login(
            LoginRequest(
                userName = email,
                password = password
            )
        ).map { LoginModel(accessToken = it.data?.accessToken ?: "") }
    }
}