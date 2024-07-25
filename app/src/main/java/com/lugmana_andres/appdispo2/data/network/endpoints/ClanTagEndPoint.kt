package com.lugmana_andres.appdispo2.data.network.endpoints

import com.lugmana_andres.appdispo2.data.network.entities.miembrosClanEntity.MiembrosClanApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ClanTagEndPoint {
    @GET("clans/{clanTag}")
    suspend fun getClanTag(@Path("clanTag") clanTag:String) : Response<MiembrosClanApi>
}