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
    @SerializedName("fullPortrait")val portrait : String?
):Parcelable
