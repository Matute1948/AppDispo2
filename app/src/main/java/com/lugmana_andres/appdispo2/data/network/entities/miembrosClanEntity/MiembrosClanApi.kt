package com.lugmana_andres.appdispo2.data.network.entities.miembrosClanEntity

data class MiembrosClanApi(
    val badgeId: Int,
    val clanChestLevel: Int,
    val clanChestMaxLevel: Int,
    val clanChestStatus: String,
    val clanScore: Int,
    val clanWarTrophies: Int,
    val description: String,
    val donationsPerWeek: Int,
    val location: Location,
    val memberList: List<Member>,
    val members: Int,
    val name: String,
    val requiredTrophies: Int,
    val tag: String,
    val type: String
)