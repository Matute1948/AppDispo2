package com.lugmana_andres.appdispo2.data.network.entities.cartasEntity

data class Item(
    val elixirCost: Int,
    val iconUrls: IconUrls,
    val id: Int,
    val maxEvolutionLevel: Int,
    val maxLevel: Int,
    val name: String,
    val rarity: String
)