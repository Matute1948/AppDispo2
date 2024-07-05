package com.lugmana_andres.appdispo2.logic.login

import android.content.Context
import com.lugmana_andres.appdispo2.data.local.repositories.DataBaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetUserWithNameAndPass(private val context : Context) {
    fun invoke(name: String, pass : String) = flow{
        delay(3000)
        val us = DataBaseRepository
            .getDBConnection(context)
            .getUserDao()
            .getUserByPassAndUser(name,pass)
        if(us!=null){
            emit(
                Result.success(us)
            )
        }else{
            emit(
                Result.failure(
                    Exception(
                        "Usuario o contraseña incorrectos."+
                        " Por favor verifique si los valores ingresado son correctos. "
                    )
                )
            )
        }
    }.catch {
        emit(Result.failure(it))
    }.flowOn(Dispatchers.IO)
}