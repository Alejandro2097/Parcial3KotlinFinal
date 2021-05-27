package com.example.parcial3kt.data

import com.google.gson.annotations.SerializedName

data class DataResponse(@SerializedName("name") val name: String, @SerializedName("shortName") val shortName: String)