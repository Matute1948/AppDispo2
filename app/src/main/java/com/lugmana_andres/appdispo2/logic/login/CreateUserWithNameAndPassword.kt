package com.lugmana_andres.appdispo2.logic.login

import android.content.Context
import com.lugmana_andres.appdispo2.data.local.database.entities.UsersDB
import com.lugmana_andres.appdispo2.data.local.repositories.DataBaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.Result

class CreateUserWithNameAndPassword(private val context: Context) {
    fun invoke(name:String, password: String) = flow{
        kotlinx.coroutines.delay(3000)
        DataBaseRepository.getDBConnection(context)
            .getUserDao().saveUser(
            listOf(
                UsersDB(
                    0,
                    name,
                    password
                )
            )
        )
        emit(Result.success(true))
    }.catch { ex->
        emit(Result.failure(ex))
    }.flowOn(Dispatchers.IO)
}