package com.ui.bookmorning.data.datasource.auth

import com.ui.bookmorning.data.service.TokenService

class AuthLocalDataSource(
    private val tokenService: TokenService
) {

    fun isUserLoggedIn() = !tokenService.token.isNullOrBlank()
    fun saveAccessToken(token: String) {
        tokenService.token = token
    }

    fun removeAccessToken() {
        tokenService.token = null
    }
}