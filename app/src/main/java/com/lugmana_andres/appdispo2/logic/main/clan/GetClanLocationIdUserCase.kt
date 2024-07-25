package com.lugmana_andres.appdispo2.logic.main.clan

import android.util.Log
import com.example.appandres.data.network.repository.RetrofitBase
import com.lugmana_andres.appdispo2.data.network.endpoints.ClanesEndPoint
import com.lugmana_andres.appdispo2.data.network.endpoints.InfoJugadorEndPoint
import com.lugmana_andres.appdispo2.ui.core.toCartasUI
import com.lugmana_andres.appdispo2.ui.core.toClanUI
import com.lugmana_andres.appdispo2.ui.entity.clan.ClanUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.MazoUsualUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetClanLocationIdUserCase {
    suspend operator fun invoke(locationId: String) = flow {
        var response = RetrofitBase.returnBaseRetrofitClashClan(locationId)
            .create(ClanesEndPoint::class.java)
            .getClanesLocationId()
        if (response.isSuccessful){
            //el body nos devuelve la data
            val x = response.body()?.items
            var items = ArrayList<ClanUI>()
            x?.forEach{
                items.add(it.toClanUI())
            }
            Log.d("TAG", items.size.toString())
            emit(Result.success(items.toList()))
        }
    }.catch{
        Log.d("TAG", it.message.toString())
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)
}