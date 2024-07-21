package com.lugmana_andres.appdispo2.data.network.entities.infoJugadorEntity

data class Badge(
    val iconUrls: IconUrls,
    val level: Int,
    val maxLevel: Int,
    val name: String,
    val progress: Int,
    val target: Int
)