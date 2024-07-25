package com.lugmana_andres.appdispo2.data.network.endpoints

import com.lugmana_andres.appdispo2.data.network.entities.clanEntity.ClanApi
import retrofit2.Response
import retrofit2.http.GET

interface ClanesEndPoint {
    @GET("clans")
    suspend fun getClanesLocationId(): Response<ClanApi>
}