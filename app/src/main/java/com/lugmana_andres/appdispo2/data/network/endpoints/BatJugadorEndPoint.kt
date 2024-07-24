package com.lugmana_andres.appdispo2.data.network.endpoints

import com.lugmana_andres.appdispo2.data.network.entities.batallasRecJugadorEntity.BatallasRecJugadorApi
import com.lugmana_andres.appdispo2.data.network.entities.batallasRecJugadorEntity.BatallasRecJugadorApiItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BatJugadorEndPoint {
    @GET("players/{playerTag}/battlelog")
    suspend fun getBatallasJugador(@Path("playerTag") playerTag: String): Response<List<BatallasRecJugadorApiItem>>
}