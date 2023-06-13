package com.bangkit.capstone.balibound.ui.screen.Splash

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
class SplashViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    var isLogged = MutableStateFlow(false)

    init{
        checkLogin()
    }

    private fun checkLogin() {
        viewModelScope.launch {
            isLogged.value = repository.getUserData() != null
        }
    }
}