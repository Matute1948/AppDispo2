package com.lugmana_andres.appdispo2.data.network.entities.cartas

data class ApiAllCartas(
    val items: List<Item>,
    val supportItems: List<SupportItem>
)