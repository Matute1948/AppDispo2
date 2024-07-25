package com.lugmana_andres.appdispo2.data.network.entities.cartasEntity

data class ApiAllCartas(
    val items: List<Item>,
    val supportItems: List<SupportItem>
)