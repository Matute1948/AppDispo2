package com.lugmana_andres.appdispo2.data.network.endpoints

import com.lugmana_andres.appdispo2.data.network.entities.batallasRecJugadorEntity.BatallasRecJugadorApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface batallasRecJugadorEndPoint {
    @GET("players/{playerTag}/upcomingchests")
    suspend fun getBatallasRecJugador(@Path("playerTag") playerTag: String): Response<BatallasRecJugadorApi>
}