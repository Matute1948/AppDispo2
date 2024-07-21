package com.lugmana_andres.appdispo2.data.network.entities.infoJugadorEntity

import com.google.gson.annotations.SerializedName

data class Progress(
    @SerializedName("goblin-road") val goblinRoad : GoblinRoad
)