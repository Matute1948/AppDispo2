package com.lugmana_andres.appdispo2.data.network.entities.clanEntity

data class Item(
    val badgeId: Int,
    val clanChestLevel: Int,
    val clanChestMaxLevel: Int,
    val clanScore: Int,
    val clanWarTrophies: Int,
    val donationsPerWeek: Int,
    val location: Location,
    val members: Int,
    val name: String,
    val requiredTrophies: Int,
    val tag: String,
    val type: String
)