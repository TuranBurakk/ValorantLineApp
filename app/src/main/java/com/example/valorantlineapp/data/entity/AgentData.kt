package com.example.valorantlineapp.data.entity

import com.google.gson.annotations.SerializedName

data class AgentData(
    @SerializedName("data")val data : List<Agent>? = null
)
data class Agent(
    @SerializedName("displayName")val name : String? = null,
    @SerializedName("description")val desc : String? = null,
    @SerializedName("displayIconSmall")val icon : String? = null,
    @SerializedName("background")val background : String? = null
)
