package com.bangkit.capstone.balibound.ui.screen.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.capstone.balibound.data.model.request.PredictRequest
import com.bangkit.capstone.balibound.data.model.response.DestinationItemResponse
import com.bangkit.capstone.balibound.data.model.response.LoginResponse
import com.bangkit.capstone.balibound.data.repository.AuthRepository
import com.bangkit.capstone.balibound.data.repository.DestinationRepository
import com.bangkit.capstone.balibound.ui.component.CardCategoryData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.bangkit.capstone.balibound.utils.Result

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val destinationRepository: DestinationRepository
) : ViewModel() {

    var loading = MutableStateFlow(false)
    var userData = MutableStateFlow<LoginResponse?>(null)
    var destinations = MutableStateFlow<ArrayList<DestinationItemResponse>>(arrayListOf())

    init {
        getUserData()
        getDestinations()
    }

    private fun getUserData() {
        viewModelScope.launch {
            userData.value = authRepository.getUserData()
        }
    }

    fun getDestinations() {
        viewModelScope.launch {
            loading.value = true
            val userData = authRepository.getUserData()
            val ratingsData = userData?.ratings ?: listOf()

            if (ratingsData.any { it != 0 }) {
                val data = destinationRepository.getRecommendation(
                    userData?.tokens?.access ?: "",
                    PredictRequest(ratings = ratingsData)
                )
                if (data is Result.Success) {
                    destinations.value = data.data
                }

            } else {
                val data = destinationRepository.getListDestinations()
                if (data is Result.Success) {
                    destinations.value = data.data
                }

            }

            loading.value = false
        }
    }

    fun searchDestinations(query: String, category: List<CardCategoryData>) {
        viewModelScope.launch {
            loading.value = true

            if(query.isEmpty() && category.all { !it.isActive }) {
                getDestinations()
                return@launch
            }

            val data = destinationRepository.getListDestinations(
                category[0].isActive,
                category[1].isActive,
                category[2].isActive,
                category[3].isActive,
                category[4].isActive,
                query = query
            )

            if (data is Result.Success) {
                destinations.value = data.data
            }

            loading.value = false
        }
    }

}