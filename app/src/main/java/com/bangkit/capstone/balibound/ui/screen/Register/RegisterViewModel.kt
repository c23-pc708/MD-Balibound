package com.bangkit.capstone.balibound.ui.screen.Register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.capstone.balibound.data.model.request.RegisterRequest
import com.bangkit.capstone.balibound.data.model.response.RegisterResponse
import com.bangkit.capstone.balibound.data.repository.AuthRepository
import com.bangkit.capstone.balibound.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    var registerState = MutableStateFlow<Result<RegisterResponse>>(Result.Empty)
    var loading = MutableStateFlow(false)

    fun register(
        username: String,
        first_name: String,
        last_name: String,
        email: String,
        phone_number: String,
        password: String
    ) {
        viewModelScope.launch {
            loading.value = true
            registerState.value = repository.register(
                RegisterRequest(
                    username,
                    first_name,
                    last_name,
                    email,
                    phone_number,
                    password
                )
            )
            loading.value = false
        }
    }

}