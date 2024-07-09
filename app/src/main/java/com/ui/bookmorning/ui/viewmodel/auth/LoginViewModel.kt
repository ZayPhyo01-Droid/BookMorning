package com.ui.bookmorning.ui.viewmodel.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ui.bookmorning.data.repository.auth.AuthRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {

    val uiState = MutableLiveData<LoginUiState>()

    //user event
    fun login(email: String, password: String) {
        uiState.value = LoginUiState.Loading
        viewModelScope.launch {
            authRepository.login(email, password)
                .fold(
                    onSuccess = {
                        uiState.value = LoginUiState.SuccessLogin
                    },
                    onFailure = {
                        uiState.value = LoginUiState.Error(it.message.toString())
                    }
                )
        }
    }
}

sealed class LoginUiState {
    object Loading : LoginUiState()

    object SuccessLogin : LoginUiState()

    data class Error(val message: String) : LoginUiState()
}