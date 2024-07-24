package com.lugmana_andres.appdispo2.ui.entity.perfil

data class BatallasJugadorUI (
    val modoJuego : String,
    val liga : Int,
    val nomArena : String,
    val jugador : List<JugadorPerfilUI>,
    val rival : List<RivalPerfilUI>
)