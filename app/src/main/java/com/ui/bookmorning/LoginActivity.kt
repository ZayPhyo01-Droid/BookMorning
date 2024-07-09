package com.ui.bookmorning

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.ui.bookmorning.databinding.ActivityLoginBinding
import com.ui.bookmorning.ui.viewmodel.auth.LoginUiState
import com.ui.bookmorning.ui.viewmodel.auth.LoginViewModel
import com.ui.bookmorning.ui.viewmodel.auth.LoginViewModelEvent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModel()

    val liveData: MutableLiveData<Int> = MutableLiveData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text
            val password = binding.edtPassword.text
            viewModel.login(
                email.toString(),
                password.toString()
            )
        }

        viewModel.uiState.observe(this) {
            when (it) {
                LoginUiState.Loading -> {}
            }
        }

        viewModel.event.observe(this) {
            when (it) {
                is LoginViewModelEvent.Error -> {}
                LoginViewModelEvent.SuccessLogin -> {
                    startActivity(
                        Intent(this, MainActivity::class.java)
                    )
                }
            }
        }
    }
}