package com.lugmana_andres.appdispo2.data.network.entities.batallasRecJugadorEntity

data class Team(
    val cards: List<Card>,
    val clan: Clan,
    val crowns: Int,
    val elixirLeaked: Double,
    val globalRank: Any,
    val kingTowerHitPoints: Int,
    val name: String,
    val princessTowersHitPoints: List<Int>,
    val startingTrophies: Int,
    val supportCards: List<SupportCard>,
    val tag: String,
    val trophyChange: Int
)