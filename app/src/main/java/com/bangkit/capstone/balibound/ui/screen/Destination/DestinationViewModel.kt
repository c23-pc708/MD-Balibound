package com.bangkit.capstone.balibound.ui.screen.Destination

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.capstone.balibound.data.model.response.DestinationItemResponse
import com.bangkit.capstone.balibound.data.model.response.LoginResponse
import com.bangkit.capstone.balibound.data.model.response.RegisterResponse
import com.bangkit.capstone.balibound.data.repository.AuthRepository
import com.bangkit.capstone.balibound.data.repository.DestinationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.bangkit.capstone.balibound.utils.Result

@HiltViewModel
class DestinationViewModel @Inject constructor(
    private val destinationRepository: DestinationRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    var loading = MutableStateFlow(false)
    var destinationState = MutableStateFlow<Result<DestinationItemResponse>>(Result.Empty)
    var destination = MutableStateFlow<DestinationItemResponse?>(null)
    var ratingDestination = MutableStateFlow(0)
    var postReviewState = MutableStateFlow<Result<RegisterResponse>>(Result.Empty)

    init {
        loading.value = true
    }

    fun getDestination(id: String? = "") {
        viewModelScope.launch {
            loading.value = true
            val data = destinationRepository.getDetailDestination(id)
            val userData = authRepository.getUserData()
            destinationState.value = data

            if (data is Result.Success) {
                destination.value = data.data
                ratingDestination.value = userData?.ratings?.get(data.data.id - 1) ?: 0
            }

            loading.value = false
        }
    }
    fun postReviewDestination(id: Int, rating: Int) {
        viewModelScope.launch {
            loading.value = true
            val userData = authRepository.getUserData()
            val token = userData?.tokens?.access ?: ""
            postReviewState.value = destinationRepository.postReviewDestination(token, id, rating)

            loading.value = false

            if (postReviewState.value is Result.Success) {
                authRepository.getUser(userData?.tokens?.access ?: "")
            }
        }
    }

}
