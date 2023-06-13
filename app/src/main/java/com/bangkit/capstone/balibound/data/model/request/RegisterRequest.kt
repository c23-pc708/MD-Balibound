package com.bangkit.capstone.balibound.data.model.request

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class RegisterRequest(
	@field:SerializedName("username")
	val username: String,

	@field:SerializedName("first_name")
	val firstName: String,

	@field:SerializedName("last_name")
	val lastName: String,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("phone_number")
	val phoneNumber: String,

	@field:SerializedName("password")
	val password: String


) : Parcelable
