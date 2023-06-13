package com.bangkit.capstone.balibound.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.bangkit.capstone.balibound.data.api.ApiAuthInterface
import com.bangkit.capstone.balibound.data.api.ApiDestinationInterface
import com.bangkit.capstone.balibound.data.model.request.LoginRequest
import com.bangkit.capstone.balibound.data.model.response.DestinationItemResponse
import com.bangkit.capstone.balibound.data.model.response.LoginResponse
import com.bangkit.capstone.balibound.utils.Result
import javax.inject.Inject

class DestinationRepository @Inject constructor(
    private val apiService: ApiDestinationInterface
) {
    suspend fun getListDestinations(
        isArt : Boolean? = true,
        isEntertainment : Boolean? = false,
        isSightings : Boolean? = false,
        isCulinary : Boolean? = false,
        isShopping : Boolean? = false,
        query : String? = ""
    ): Result<ArrayList<DestinationItemResponse>> {
        return try {
            Result.Success(apiService.getDestination(
                art = isArt,
                entertainment = isEntertainment,
                sightings = isSightings,
                culinary = isCulinary,
                shopping = isShopping,
                q = query
            ))
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }

    suspend fun getDetailDestination(id: String? = ""): Result<DestinationItemResponse> {
        return try {
            Result.Success(apiService.getDestinationById(id))
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }
}