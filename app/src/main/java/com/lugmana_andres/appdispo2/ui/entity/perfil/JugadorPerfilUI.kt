package com.lugmana_andres.appdispo2.ui.entity.perfil

data class JugadorPerfilUI (
    val nombreJuga : String,
    val nomCoronasJuga : Int,
    val nombreClan : String,
    val tagClan : String,
    val cartasJugador : List<MazoUsualUI>,
    val nomTorreJuga : String,
    val imagTorreJu : String,
)