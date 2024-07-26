package com.lugmana_andres.appdispo2.data.network.endpoints

import com.lugmana_andres.appdispo2.data.network.entities.topsForSeason.TopsForSeasonApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TopsForSeasonEndPoint {
    @GET("locations/global/pathoflegend/{seasonId}/rankings/players")
    suspend fun getTopsForSeason(@Path("seasonId") seasonId : String): Response<TopsForSeasonApi>

}