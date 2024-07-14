package com.lugmana_andres.appdispo2.ui.core

import com.example.appandres.data.network.entity.allCartas.Item
import com.lugmana_andres.appdispo2.ui.entity.clashRoyale.CartasUI


fun Item.toCartasUI() = CartasUI (
        id = this.id,
        name = this.name,
        costo = this.elixirCost,
        calidad = this.rarity,
        imagen = this.iconUrls.medium
    )
