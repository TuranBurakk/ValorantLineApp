package com.infos.valorantlineapp.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MapData(
    @SerializedName("data")val Map : List<Map>? = null
):Parcelable

@Parcelize
data class Map(
    @SerializedName("displayName")val name : String? = null,
    @SerializedName("listViewIcon")val icon : String? = null
):Parcelable
