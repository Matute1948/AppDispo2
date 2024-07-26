package com.lugmana_andres.appdispo2.data.network.repository

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class TopsInterceptor(private val apiKey: String): Interceptor  {
    override fun intercept(chain: Interceptor.Chain): Response {
        // Obtén la solicitud original
        val originalRequest = chain.request()

        // Construye la nueva URL con los parámetros query
        val newUrl = originalRequest.url.newBuilder()
            .addQueryParameter("limit", "100")
            .build()

        // Construye la nueva solicitud con la URL modificada y el encabezado de autorización
        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .addHeader("Authorization", "Bearer $apiKey")
            .build()

        // Registra la nueva URL para fines de depuración
        Log.d("TAG", newRequest.url.toString())

        // Procede con la nueva solicitud
        return chain.proceed(newRequest)
    }
}