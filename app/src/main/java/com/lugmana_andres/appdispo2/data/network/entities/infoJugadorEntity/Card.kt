package com.lugmana_andres.appdispo2.data.network.entities.infoJugadorEntity

data class Card(
    val count: Int,
    val elixirCost: Int,
    val evolutionLevel: Int,
    val iconUrls: IconUrls,
    val id: Int,
    val level: Int,
    val maxEvolutionLevel: Int,
    val maxLevel: Int,
    val name: String,
    val rarity: String,
    val starLevel: Int
)