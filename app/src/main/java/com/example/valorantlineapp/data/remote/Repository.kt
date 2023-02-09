package com.example.valorantlineapp.data.remote

import com.example.valorantlineapp.data.entity.AgentData
import com.example.valorantlineapp.data.entity.MapData
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getAgent(): AgentData{
       return remoteDataSource.getAgent()
    }

    suspend fun getMaps(): MapData {
        return remoteDataSource.getMaps()
    }
}