package com.example.appandres.data.network.endpoints

import com.lugmana_andres.appdispo2.data.network.entities.cartas.ApiAllCartas
import retrofit2.Response
import retrofit2.http.GET

interface CartasEndPoint {
    @GET("cards")
    suspend fun getAllCartas(): Response<ApiAllCartas>
}