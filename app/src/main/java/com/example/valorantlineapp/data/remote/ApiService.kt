package com.example.valorantlineapp.data.remote

import com.example.valorantlineapp.data.entity.AgentData
import retrofit2.http.GET

interface ApiService {

    @GET("agents")
    suspend fun getAgent() : AgentData
}