package com.example.valorantlineapp.ui.homeScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantlineapp.data.entity.AgentData
import com.example.valorantlineapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject  constructor(
    private val agentUseCase: AgentUseCase
): ViewModel(){
    private val _agent = MutableLiveData<AgentData?>()
    val agent : LiveData<AgentData?> = _agent

    init {
        getAgents()
    }

    private fun getAgents(){
        agentUseCase().onEach { result ->
            when (result.status) {
                Resource.Status.SUCCESS ->{
                    _agent.value = result.data
                }
                Resource.Status.ERROR -> {
                }
                Resource.Status.LOADING ->{
                }
            }

        }.launchIn(viewModelScope)
    }
}