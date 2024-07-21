package com.lugmana_andres.appdispo2.data.network.endpoints

import com.lugmana_andres.appdispo2.data.network.entities.infoJugadorEntity.InfoJugadorAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface InfoJugadorEndPoint {
    @GET("players/{playerTag}")
    suspend fun getInfoJugador(@Path("playerTag") playerTag: String): Response<InfoJugadorAPI>
}