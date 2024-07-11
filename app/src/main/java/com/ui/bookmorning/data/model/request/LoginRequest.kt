package com.ui.bookmorning.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    @SerialName("user_name")
    val userName: String,
    val password: String
) {
}