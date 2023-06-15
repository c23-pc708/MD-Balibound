package com.bangkit.capstone.balibound.data.repository

import com.bangkit.capstone.balibound.data.api.ApiDestinationInterface
import com.bangkit.capstone.balibound.data.model.request.PredictRequest
import com.bangkit.capstone.balibound.data.model.response.DestinationItemResponse
import com.bangkit.capstone.balibound.data.model.response.RegisterResponse
import com.bangkit.capstone.balibound.utils.Result
import com.bangkit.capstone.balibound.utils.ext.toInt
import javax.inject.Inject

class DestinationRepository @Inject constructor(
    private val apiService: ApiDestinationInterface,
) {
    suspend fun getListDestinations(): Result<ArrayList<DestinationItemResponse>> {
        return try {
            Result.Success(
                apiService.getDestination(
                    art = 1,
                    entertainment = 0,
                    sightings = 0,
                    culinary = 0,
                    shopping = 0,
                    q = ""
                )
            )
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }

    suspend fun getListDestinations(
        isArt: Boolean,
        isEntertainment: Boolean,
        isSightings: Boolean,
        isCulinary: Boolean,
        isShopping: Boolean,
        query: String? = ""
    ): Result<ArrayList<DestinationItemResponse>> {
        return try {
            Result.Success(
                apiService.getDestination(
                    art = isArt.toInt(),
                    entertainment = isEntertainment.toInt(),
                    sightings = isSightings.toInt(),
                    culinary = isCulinary.toInt(),
                    shopping = isShopping.toInt(),
                    q = query
                )
            )
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

    suspend fun postReviewDestination(
        token: String,
        id: Int,
        rating: Int
    ): Result<RegisterResponse> {
        return try {
            Result.Success(apiService.postReviewDestination("Bearer $token", id, rating))
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }

    suspend fun getRecommendation(
        token : String,
        predictRequest: PredictRequest
    ): Result<ArrayList<DestinationItemResponse>> {
        return try {
            Result.Success(apiService.getPredict("Bearer $token", predictRequest))
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }
}