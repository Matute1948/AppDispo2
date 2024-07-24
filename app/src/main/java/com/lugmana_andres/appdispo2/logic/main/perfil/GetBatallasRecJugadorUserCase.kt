package com.lugmana_andres.appdispo2.logic.main.perfil

import android.util.Log
import com.example.appandres.data.network.repository.RetrofitBase
import com.lugmana_andres.appdispo2.data.network.endpoints.BatJugadorEndPoint
import com.lugmana_andres.appdispo2.ui.core.toBatallasJugadorUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.BatallasJugadorUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetBatallasRecJugadorUserCase {

    suspend operator fun invoke(playerTag : String) = flow {
        var response = RetrofitBase.returnBaseRetrofitClash()
            .create(BatJugadorEndPoint::class.java)
            .getBatallasJugador(playerTag)
        if (response.isSuccessful){
            val x = response.body()
            var items = ArrayList<BatallasJugadorUI>()
            x?.forEach {
                items.add(it.toBatallasJugadorUI())
            }
            Log.d("TAGXD", x.toString())
            emit(Result.success(items.toList()))
        }
    }.catch {
        Log.d("TAG", it.message.toString())
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)
}