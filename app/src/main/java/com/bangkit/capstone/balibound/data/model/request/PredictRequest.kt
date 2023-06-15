package com.bangkit.capstone.balibound.data.model.request

import com.google.gson.annotations.SerializedName

data class PredictRequest(

	@field:SerializedName("ratings")
	val ratings: List<Int>
)
