package com.lugmana_andres.appdispo2.logic.login


import com.lugmana_andres.appdispo2.data.local.firabase.FirestoreRepository
import com.lugmana_andres.appdispo2.ui.entity.users.UserLogin
import kotlinx.coroutines.flow.flow

class SaveUserFireStoreUserCase {

    suspend fun invoke(user: UserLogin) = flow {
        val x = FirestoreRepository().saveUserLogin(user)

        x.onSuccess {
            emit(it)
        }

        x.onFailure {
            emit(false)
        }
    }

}