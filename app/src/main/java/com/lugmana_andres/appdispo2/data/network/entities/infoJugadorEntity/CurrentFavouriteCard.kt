package com.lugmana_andres.appdispo2.data.network.entities.infoJugadorEntity

data class CurrentFavouriteCard(
    val elixirCost: Int,
    val iconUrls: IconUrls,
    val id: Int,
    val maxLevel: Int,
    val name: String,
    val rarity: String
)