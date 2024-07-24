package com.lugmana_andres.appdispo2.logic.main.perfil

import android.util.Log
import com.example.appandres.data.network.repository.RetrofitBase
import com.lugmana_andres.appdispo2.data.network.endpoints.InfoJugadorEndPoint
import com.lugmana_andres.appdispo2.ui.core.toCartasUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.MazoUsualUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCartasJugadorUserCase {
    suspend operator fun invoke(playerTag : String) = flow {
        var response = RetrofitBase.returnBaseRetrofitClash()
            .create(InfoJugadorEndPoint::class.java)
            .getInfoJugador(playerTag)
        if (response.isSuccessful){
            //el body nos devuelve la data
            val x = response.body()?.cards
            var items = ArrayList<MazoUsualUI>()
            x?.forEach{
                items.add(it.toCartasUI())
            }
            Log.d("TAG", items.size.toString())
            emit(Result.success(items.toList()))
        }
    }.catch{
        Log.d("TAG", it.message.toString())
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)
}