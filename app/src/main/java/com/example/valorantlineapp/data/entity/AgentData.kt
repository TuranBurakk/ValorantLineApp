package com.example.valorantlineapp.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AgentData(
    @SerializedName("data")val data : List<Agent>?
):Parcelable

@Parcelize
data class Agent(
    @SerializedName("displayName")val name : String? ,
    @SerializedName("description")val desc : String?,
    @SerializedName("displayIconSmall")val icon : String? ,
    @SerializedName("fullPortrait")val portrait : String? ,
    @SerializedName("abilities")val ability : List<Ability>?
):Parcelable

@Parcelize
data class Ability(
    @SerializedName("displayName")val abilityName : String?,
    @SerializedName("description")val abilityDesc : String?,
    @SerializedName("displayIcon")val abilityIcon : String?
):Parcelable
