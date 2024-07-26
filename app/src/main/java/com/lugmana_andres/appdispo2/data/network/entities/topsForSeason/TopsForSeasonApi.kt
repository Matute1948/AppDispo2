package com.lugmana_andres.appdispo2.data.network.entities.topsForSeason

data class TopsForSeasonApi(
    val items: List<Item>,
    val paging: Paging
)