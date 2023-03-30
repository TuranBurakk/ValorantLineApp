package com.infos.valorantlineapp.ui.lineUpScreen

import com.infos.valorantlineapp.data.entity.MapData
import com.infos.valorantlineapp.data.remote.Repository
import com.infos.valorantlineapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MapUseCase @Inject constructor(
    private val repository: Repository
){
    operator fun invoke(): Flow<Resource<MapData>> = flow {
        try {

            emit(Resource.loading())
            val maps = repository.getMaps()
            emit(Resource.success(maps))
        }catch (e: HttpException){
            emit(Resource.error(e.localizedMessage))
        }catch (e : IOException){
            emit(Resource.error("Check your internet connect "))
        }
    }
}