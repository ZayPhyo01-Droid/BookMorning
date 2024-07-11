package com.ui.bookmorning.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val code: Int,
    val message: String,
    val data:LoginData?
)

@Serializable
data class LoginData(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("user_name")
    val userName: String,
    @SerialName("phone_number")
    val phone: String,
    val email: String
)
