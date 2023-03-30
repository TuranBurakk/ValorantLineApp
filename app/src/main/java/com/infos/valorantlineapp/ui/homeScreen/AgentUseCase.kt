package com.infos.valorantlineapp.ui.homeScreen

import com.infos.valorantlineapp.data.entity.AgentData
import com.infos.valorantlineapp.data.remote.Repository
import com.infos.valorantlineapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AgentUseCase @Inject constructor(
    private val repository: Repository
){
    operator fun invoke(): Flow<Resource<AgentData>> = flow {
        try {

            emit(Resource.loading())
            val agent = repository.getAgent("en-US",true)
            emit(Resource.success(agent))
        }catch (e: HttpException){
            emit(Resource.error(e.localizedMessage))
        }catch (e : IOException){
            emit(Resource.error("Check your internet connect "))
        }
    }
}