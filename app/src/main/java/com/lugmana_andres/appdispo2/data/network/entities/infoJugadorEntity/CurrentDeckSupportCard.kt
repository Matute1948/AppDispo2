package com.lugmana_andres.appdispo2.data.network.entities.infoJugadorEntity

data class CurrentDeckSupportCard(
    val count: Int,
    val iconUrls: IconUrls,
    val id: Int,
    val level: Int,
    val maxLevel: Int,
    val name: String,
    val rarity: String
)