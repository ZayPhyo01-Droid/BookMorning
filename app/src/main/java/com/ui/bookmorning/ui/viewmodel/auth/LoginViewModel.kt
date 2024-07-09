package com.ui.bookmorning.ui.viewmodel.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ui.bookmorning.data.repository.auth.AuthRepository
import com.ui.bookmorning.util.SingleLiveEvent
import kotlinx.coroutines.launch

// state , view event -> viewmodel
// ui should not , render

class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableLiveData<LoginUiState>()
    val uiState : LiveData<LoginUiState> = _uiState

    val event = SingleLiveEvent<LoginViewModelEvent>()

    //user event
    fun login(email: String, password: String) {
        _uiState.value = LoginUiState.Loading
        viewModelScope.launch {
            authRepository.login(email, password)
                .fold(
                    onSuccess = {
                        event.value = LoginViewModelEvent.SuccessLogin
                    },
                    onFailure = {
                        event.value = LoginViewModelEvent.Error(it.message.toString())
                    }
                )
        }
    }
}

sealed class LoginUiState {
    object Loading : LoginUiState()
}

sealed class LoginViewModelEvent {
    object SuccessLogin : LoginViewModelEvent()

    data class Error(val message: String) : LoginViewModelEvent()
}