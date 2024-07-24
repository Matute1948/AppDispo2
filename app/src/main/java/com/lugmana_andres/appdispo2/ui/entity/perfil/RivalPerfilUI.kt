package com.lugmana_andres.appdispo2.ui.entity.perfil

data class RivalPerfilUI (
    val nomRival : String,
    val tagRival : String,
    val numCoronasRiva : Int,
    val nomClan : String,
    val tagClan : String,
    val cartasRival : List<MazoUsualUI>,
    val nomTorre : String,
    val imagTorre : String,
)