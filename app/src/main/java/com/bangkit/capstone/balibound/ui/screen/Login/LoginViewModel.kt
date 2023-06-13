package com.bangkit.capstone.balibound.ui.screen.Login

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.capstone.balibound.data.model.response.LoginResponse
import com.bangkit.capstone.balibound.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import com.bangkit.capstone.balibound.utils.Result
import dagger.hilt.android.internal.Contexts.getApplication

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    var loginState = MutableStateFlow<Result<LoginResponse>>(Result.Empty)
    var loading = MutableStateFlow(false)

    fun login(username: String, password: String) {
        viewModelScope.launch {
            loading.value = true
            val data = repository.login(username, password)
            loginState.value = data

            if(data is Result.Success) {
                repository.saveUserData(data.data)
            }

            loading.value = false
        }
    }

}