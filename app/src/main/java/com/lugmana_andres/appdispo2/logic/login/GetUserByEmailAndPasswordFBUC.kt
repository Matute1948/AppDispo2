package com.lugmana_andres.appdispo2.logic.login

import com.lugmana_andres.appdispo2.data.local.firabase.FirestoreRepository
import com.lugmana_andres.appdispo2.ui.entity.users.UserLogin
import kotlinx.coroutines.flow.flow

class GetUserByEmailAndPasswordFBUC {

    suspend fun invoke(id: String) = flow<Result<UserLogin>> {
        FirestoreRepository().getUserById(id)
            .onSuccess {
                emit(Result.success(it.first()))
            }
            .onFailure { error ->
                emit(Result.failure(error))
            }
    }
}