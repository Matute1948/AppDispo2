package com.lugmana_andres.appdispo2.data.network.entities.topsForSeason

data class Item(
    val clan: Clan,
    val eloRating: Int,
    val expLevel: Int,
    val name: String,
    val rank: Int,
    val tag: String
)