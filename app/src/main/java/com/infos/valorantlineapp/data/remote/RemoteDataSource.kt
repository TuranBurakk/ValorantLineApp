package com.infos.valorantlineapp.data.remote

import com.infos.valorantlineapp.data.entity.AgentData
import com.infos.valorantlineapp.data.entity.MapData
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
){
    suspend fun getAgent(
        language: String, isPlayableCharacter: Boolean
    ): AgentData{
       return apiService.getAgent(language, isPlayableCharacter)
    }

    suspend fun getMaps(): MapData{
        return apiService.getMap()
    }
}