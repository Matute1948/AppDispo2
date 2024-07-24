package com.lugmana_andres.appdispo2.logic.main.perfil.info

import android.util.Log
import com.example.appandres.data.network.repository.RetrofitBase
import com.lugmana_andres.appdispo2.data.network.endpoints.CofresJugadorEndPoint
import com.lugmana_andres.appdispo2.ui.core.toCofresJugadorUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.CofresJugadorUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCofresJugadorUserCase {
    suspend operator fun invoke(playerTag : String) = flow {
        var response = RetrofitBase.returnBaseRetrofitClash()
            .create(CofresJugadorEndPoint::class.java)
            .getCofresJugador(playerTag)
        if (response.isSuccessful){
            //el body nos devuelve la data
            val x = response.body()?.items
            var items = ArrayList<CofresJugadorUI>()
            x?.forEach{
                items.add(it.toCofresJugadorUI())
            }
            Log.d("TAG", items.size.toString())
            emit(Result.success(items.toList()))
        }
    }.catch{
        Log.d("TAG", it.message.toString())
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)
}