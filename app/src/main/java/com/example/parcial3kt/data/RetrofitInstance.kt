package com.example.parcial3kt.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    private fun getInstance(): Retrofit{
        val gson = GsonBuilder().create()
        return Retrofit.Builder()
            .baseUrl("https://volleyball-data.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    fun bingApi(): BingApi{
        return getInstance().create(BingApi::class.java)
    }
}