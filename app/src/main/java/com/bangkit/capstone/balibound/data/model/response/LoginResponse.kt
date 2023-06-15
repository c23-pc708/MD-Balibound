package com.bangkit.capstone.balibound.data.model.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("ratings")
	val ratings: List<Int>,

	@field:SerializedName("last_name")
	val lastName: String,

	@field:SerializedName("phone_number")
	val phoneNumber: String,

	@field:SerializedName("tokens")
	var tokens: Tokens,

	@field:SerializedName("first_name")
	val firstName: String,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("username")
	val username: String
)

data class Tokens(

	@field:SerializedName("access")
	val access: String,

	@field:SerializedName("refresh")
	val refresh: String
)
