package com.infos.valorantlineapp.ui.lineUpScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.infos.valorantlineapp.data.entity.MapData
import com.infos.valorantlineapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LineUpViewModel @Inject constructor(
    private val useCase: MapUseCase
): ViewModel()  {
    private val _maps = MutableLiveData<MapData?>()
    val maps : LiveData<MapData?> = _maps

    init {
       getMaps()
    }

    fun getMaps() {
        useCase().onEach { result ->
            when (result.status) {
                Resource.Status.SUCCESS ->{
                    _maps.value = result.data
                }
                Resource.Status.ERROR -> {
                }
                Resource.Status.LOADING ->{
                }
            }

        }.launchIn(viewModelScope)
    }

    }
