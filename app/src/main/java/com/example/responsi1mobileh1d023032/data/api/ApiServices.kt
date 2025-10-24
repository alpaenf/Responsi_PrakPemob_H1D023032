package com.example.responsi1mobileh1d023032.data.api

import com.example.responsi1mobileh1d023032.data.model.Coach
import com.example.responsi1mobileh1d023032.data.model.Team
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @Headers("X-Auth-Token: 49510879a84240eb886b8f0447365e06")
    @GET("teams/{id}")
    suspend fun getTeam(@Path("id") id: Int): Team

    @Headers("X-Auth-Token: 49510879a84240eb886b8f0447365e06")
    @GET("persons/{id}")
    suspend fun getCoach(@Path("id") id: Int): Coach
}
