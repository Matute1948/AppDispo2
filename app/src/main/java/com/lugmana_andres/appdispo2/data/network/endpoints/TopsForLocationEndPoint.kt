package com.lugmana_andres.appdispo2.data.network.endpoints

import com.lugmana_andres.appdispo2.data.network.entities.topsForLocation.TopsForLocationApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TopsForLocationEndPoint {

    @GET("locations/{locationId}/pathoflegend/players")
    suspend fun getTopsForLocation(@Path("locationId") locationId : String): Response<TopsForLocationApi>

}