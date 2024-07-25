package com.lugmana_andres.appdispo2.logic.main.clan

import android.util.Log
import com.example.appandres.data.network.repository.RetrofitBase
import com.lugmana_andres.appdispo2.data.network.endpoints.ClanTagEndPoint
import com.lugmana_andres.appdispo2.ui.core.toClanUI
import com.lugmana_andres.appdispo2.ui.core.toMiembroUI
import com.lugmana_andres.appdispo2.ui.entity.clan.MiembroUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetClanTagUserCase {

    suspend operator fun invoke(clanTag : String) = flow {
        var response = RetrofitBase.returnBaseRetrofitClash()
            .create(ClanTagEndPoint::class.java)
            .getClanTag(clanTag)
        if (response.isSuccessful){
            //el body nos devuelve la data
            val x = response.body()?.memberList
            var items = ArrayList<MiembroUI>()
            x?.forEach {
                items.add(it.toMiembroUI())
            }
            Log.d("TAG", x.toString())
            emit(Result.success(items.toList()))
        }
    }.catch{
        Log.d("TAG", it.message.toString())
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)

}