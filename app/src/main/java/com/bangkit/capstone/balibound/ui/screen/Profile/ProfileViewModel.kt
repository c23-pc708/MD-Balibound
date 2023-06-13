package com.bangkit.capstone.balibound.ui.screen.Profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.capstone.balibound.data.model.response.DestinationItemResponse
import com.bangkit.capstone.balibound.data.model.response.LoginResponse
import com.bangkit.capstone.balibound.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    var userData = MutableStateFlow<LoginResponse?>(null)

    init {
        getUserData()
    }

    private fun getUserData() {
        viewModelScope.launch {
            userData.value = authRepository.getUserData()
        }
    }

    fun logout() {
        viewModelScope.launch {
            authRepository.clearUserData()
            userData.value = null
        }
    }

}