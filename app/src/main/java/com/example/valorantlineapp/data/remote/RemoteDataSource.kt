package com.example.valorantlineapp.data.remote

import com.example.valorantlineapp.data.entity.AgentData
import com.example.valorantlineapp.data.entity.MapData
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
){
    suspend fun getAgent(): AgentData{
       return apiService.getAgent()
    }

    suspend fun getMaps(): MapData{
        return apiService.getMap()
    }
}