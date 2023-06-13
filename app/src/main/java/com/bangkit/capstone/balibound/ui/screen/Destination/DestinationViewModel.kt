package com.bangkit.capstone.balibound.ui.screen.Destination

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.capstone.balibound.data.model.response.DestinationItemResponse
import com.bangkit.capstone.balibound.data.repository.DestinationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.bangkit.capstone.balibound.utils.Result

@HiltViewModel
class DestinationViewModel @Inject constructor(
    private val destinationRepository: DestinationRepository
) : ViewModel() {

    var loading = MutableStateFlow(false)
    var destinationState = MutableStateFlow<Result<DestinationItemResponse>>(Result.Empty)
    var destination = MutableStateFlow<DestinationItemResponse?>(null)

    init {
        loading.value = true
    }

    fun getDestination(id: String? = "") {
        viewModelScope.launch {
            loading.value = true
            val data = destinationRepository.getDetailDestination(id)

            if (data is Result.Success) {
                destination.value = data.data
            }

            loading.value = false
        }
    }

}
