package com.lugmana_andres.appdispo2.data.network.endpoints

import com.lugmana_andres.appdispo2.data.network.entities.cofresJugadorEntity.CofresJugadorApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CofresJugadorEndPoint {
    @GET("players/{playerTag}/upcomingchests")
    suspend fun getCofresJugador(@Path("playerTag") playerTag: String): Response<CofresJugadorApi>
}