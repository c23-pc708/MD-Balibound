package com.bangkit.capstone.balibound.data.model.response

import com.google.gson.annotations.SerializedName

data class DestinationItemResponse(
	@field:SerializedName("art")
	val art: Int,

	@field:SerializedName("location_link")
	val locationLink: String,

	@field:SerializedName("image_link")
	val imageLink: String,

	@field:SerializedName("entertainment")
	val entertainment: Int,

	@field:SerializedName("lowest_price")
	val lowestPrice: Int,

	@field:SerializedName("rating")
	val rating: Any,

	@field:SerializedName("sightings")
	val sightings: Int,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("highest_price")
	val highestPrice: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("weekdays_time")
	val weekdaysTime: String,

	@field:SerializedName("weekend_time")
	val weekendTime: String,

	@field:SerializedName("culinary")
	val culinary: Int,

	@field:SerializedName("location")
	val location: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("shopping")
	val shopping: Int
)
