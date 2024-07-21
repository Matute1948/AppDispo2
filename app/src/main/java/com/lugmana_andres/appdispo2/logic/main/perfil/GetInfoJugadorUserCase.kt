package com.lugmana_andres.appdispo2.logic.main.perfil

import android.util.Log
import com.example.appandres.data.network.repository.RetrofitBase
import com.lugmana_andres.appdispo2.data.network.endpoints.InfoJugadorEndPoint
import com.lugmana_andres.appdispo2.ui.core.toEstadisticasJugadorUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetInfoJugadorUserCase {

    suspend operator fun invoke(playerTag : String) = flow{
        var response = RetrofitBase.returnBaseRetrofitClash()
            .create(InfoJugadorEndPoint::class.java)
            .getInfoJugador(playerTag)

        if (response.isSuccessful){
            val x = response.body()?.toEstadisticasJugadorUI()
            Log.d("TAG", x.toString())
            emit(Result.success(x))
        }
    }.catch {
        Log.d("TAG", it.message.toString())
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)
}