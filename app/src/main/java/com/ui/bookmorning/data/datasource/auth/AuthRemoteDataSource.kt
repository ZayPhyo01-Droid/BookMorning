package com.ui.bookmorning.data.datasource.auth

import com.ui.bookmorning.domain.model.auth.LoginModel
import kotlinx.coroutines.delay

class AuthRemoteDataSource {

    suspend fun login(email: String, password: String): Result<LoginModel> {
        delay(1000)
        return Result.success(LoginModel("User", password = "abc123"))
    }
}