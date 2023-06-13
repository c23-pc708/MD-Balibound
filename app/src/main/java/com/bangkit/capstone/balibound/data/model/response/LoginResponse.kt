package com.bangkit.capstone.balibound.data.model.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("last_name")
	val lastName: String? = null,

	@field:SerializedName("phone_number")
	val phoneNumber: String? = null,

	@field:SerializedName("tokens")
	val tokens: Tokens? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("message")
	val message: String? = null

)

data class Tokens(

	@field:SerializedName("access")
	val access: String,

	@field:SerializedName("refresh")
	val refresh: String
)
