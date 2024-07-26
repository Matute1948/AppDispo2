package com.lugmana_andres.appdispo2.logic.main.tops

import android.util.Log
import com.example.appandres.data.network.repository.RetrofitBase
import com.lugmana_andres.appdispo2.data.network.endpoints.TopsForLocationEndPoint
import com.lugmana_andres.appdispo2.ui.core.toTopsUILocation
import com.lugmana_andres.appdispo2.ui.core.toTopsUISeason
import com.lugmana_andres.appdispo2.ui.entity.tops.TopsUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetTopsForLocation {
    suspend operator fun invoke(locationId : String) = flow {
        var response = RetrofitBase.returnBaseRetrofitClashTops()
            .create(TopsForLocationEndPoint::class.java)
            .getTopsForLocation(locationId)
        if (response.isSuccessful){
            //el body nos devuelve la data
            val x = response.body()?.items
            var items = ArrayList<TopsUI>()
            x?.forEach {
                items.add(it.toTopsUILocation())
            }
            Log.d("TAG", x.toString())
            emit(Result.success(items.toList()))
        }
    }.catch{
        Log.d("TAG", it.message.toString())
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)
}