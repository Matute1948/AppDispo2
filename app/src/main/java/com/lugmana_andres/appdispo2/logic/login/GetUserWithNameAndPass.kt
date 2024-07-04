package com.lugmana_andres.appdispo2.logic.login

import android.content.Context
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class GetUserWithNameAndPass(private val context : Context) {
    fun invoke(name: String, pass : String) = flow{
        delay(3000)
    }
}