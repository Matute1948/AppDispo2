package com.lugmana_andres.appdispo2.ui.entity.perfil

data class EstadisticasInfoJugadorUI(

    //Camino de trofeos
    val maxNumTrofeos : Int,
    val trofeos : Int,
    val arenaCamino : String,

    //Camino de duendes

    val maxNumTrofeosDuendes : Int,
    val trofeosDuendes: Int,
    val arenaDuende: String,

    //Camino de leyendas
    //Actual
    val actualLiga : Int,
    val anteriorLiga : Int,
    val mejorLiga : Int,

    //Insignias principales primeras 8
    val insigniasPrincipales : List<InsigniaUI>,

    //Estadisticas generales
    val numVictorias : Int,
    val numDerrotas : Int,
    val numVictorias3Coronos : Int,
    val cartasEncontradas : Int,
    val cartaFavorita : String,
    val numDonacionesTotales : Int,

    //Deck usual
    val mazoUso : List<MazoUsualUI>,
    val nombreTorre : String,
    val calidadTorre : String,
    val nivelTorre : Int,
    val imagenTorre : String,

    //Estadisticas de desafio
    val maximoVictoriasDesafio : Int,
    val maximoCartasGanadasDesafio : Int,

    //Torneos
    val maximoCartasGanadasTorneos : Int,
    val numBatallasTorneos : Int,

    //Batalla de clanes
    val numDiaVicGuerra : Int,
    val cartasReunidasClan : Int

)
