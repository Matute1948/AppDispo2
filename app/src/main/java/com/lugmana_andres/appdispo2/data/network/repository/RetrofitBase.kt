package com.example.appandres.data.network.repository

import com.lugmana_andres.appdispo2.data.network.repository.ClashClanInterceptor
import com.lugmana_andres.appdispo2.data.network.repository.TopsInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBase {
    //API CLASH-----
    fun returnBaseRetrofitClash(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.clashroyale.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(apiClienteClash())
            .build()
    }

    //API Clan
    fun returnBaseRetrofitClashClan(locationId : String): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.clashroyale.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(apiClienteClashClan(locationId))
            .build()
    }
    //Api tops players
    fun returnBaseRetrofitClashClan(param : String): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.clashroyale.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(a (param))
            .build()
    }


    private fun apiClienteClash() : OkHttpClient = OkHttpClient.Builder().addInterceptor(ClashInterceptor(ApiKeys.API_CLASH)).build()
    private fun apiClienteClashClan(locationId : String) : OkHttpClient = OkHttpClient.Builder().addInterceptor(ClashClanInterceptor(ApiKeys.API_CLASH,locationId)).build()
    private fun apiClienteClashTop( ) : OkHttpClient = OkHttpClient.Builder().addInterceptor(TopsInterceptor(ApiKeys.API_CLASH)).build()
}