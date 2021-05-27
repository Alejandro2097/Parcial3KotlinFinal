package com.example.parcial3kt.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BingApi {
    @Headers("x-rapidapi-key: 35c64c80a8msh725e294301d40e8p18ac17jsn00c0f709149d",
        "x-rapidapi-host: volleyball-data.p.rapidapi.com", "useQueryString: true")
    @GET("tournament/teams")
    fun searchLeague(@Query("tournamentId")query:Int): Call<LigaResponse>
}