package com.bangkit.capstone.balibound.data.api

import com.bangkit.capstone.balibound.data.model.request.PredictRequest
import com.bangkit.capstone.balibound.data.model.response.DestinationItemResponse
import com.bangkit.capstone.balibound.data.model.response.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiDestinationInterface {
    @GET("api/destinations")
    suspend fun getDestination(
        @Query("art") art: Int,
        @Query("entertainment") entertainment: Int,
        @Query("sightings") sightings: Int,
        @Query("culinary") culinary: Int,
        @Query("shopping") shopping: Int,
        @Query("q") q: String? = ""
    ): ArrayList<DestinationItemResponse>

    @GET("api/destinations/{id}")
    suspend fun getDestinationById(
        @Path("id") id: String? = ""
    ): DestinationItemResponse

    @POST("auth/ratings")
    suspend fun postReviewDestination(
        @Header("Authorization") token: String,
        @Query("destId") destId: Int = 0,
        @Query("rating") rating: Int = 0,
    ): RegisterResponse

    @POST("/api/predict")
    suspend fun getPredict(
        @Header("Authorization") token: String,
        @Body bodyPredict: PredictRequest
    ): ArrayList<DestinationItemResponse>

}