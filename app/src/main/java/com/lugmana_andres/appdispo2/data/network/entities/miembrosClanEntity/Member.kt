package com.lugmana_andres.appdispo2.data.network.entities.miembrosClanEntity

data class Member(
    val arena: Arena,
    val clanChestPoints: Int,
    val clanRank: Int,
    val donations: Int,
    val donationsReceived: Int,
    val expLevel: Int,
    val lastSeen: String,
    val name: String,
    val previousClanRank: Int,
    val role: String,
    val tag: String,
    val trophies: Int
)