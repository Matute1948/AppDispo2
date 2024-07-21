package com.lugmana_andres.appdispo2.logic.main.perfil

import android.util.Log
import com.example.appandres.data.network.endpoints.CartasEndPoint
import com.example.appandres.data.network.repository.RetrofitBase
import com.lugmana_andres.appdispo2.ui.core.toCartasUI
import com.lugmana_andres.appdispo2.ui.entity.clashRoyale.CartasUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.Result

class GetAllCartasUserCase {
    suspend operator fun invoke() = flow {
        var response = RetrofitBase.returnBaseRetrofitClash()
            .create(CartasEndPoint::class.java)
            .getAllCartas()
        if (response.isSuccessful){
            //el body nos devuelve la data
            val x = response.body()?.items
            var items = ArrayList<CartasUI>()
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