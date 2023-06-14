package com.bangkit.capstone.balibound.data.api

import com.bangkit.capstone.balibound.data.model.response.DestinationItemResponse
import retrofit2.http.Body
import retrofit2.http.GET
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
}