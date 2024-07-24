package com.lugmana_andres.appdispo2.ui.viewModels.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lugmana_andres.appdispo2.logic.main.perfil.GetBatallasRecJugadorUserCase
import com.lugmana_andres.appdispo2.logic.main.perfil.GetCartasJugadorUserCase
import com.lugmana_andres.appdispo2.ui.core.UIStates
import com.lugmana_andres.appdispo2.ui.entity.perfil.BatallasJugadorUI
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BatallasJugadorVM  : ViewModel() {
    val batallas = MutableLiveData<List<BatallasJugadorUI>>()
    val uiState = MutableLiveData<UIStates>()

    fun initData(playerTag: String){
        viewModelScope.launch {
            uiState.postValue(UIStates.Loading(true))
            GetBatallasRecJugadorUserCase().invoke(playerTag).collect{ respAC ->
                respAC.onSuccess {
                    batallas.postValue(it)
                }
                respAC.onFailure {
                    uiState.postValue(UIStates.Error(it.message.toString()))
                    Log.d("TAG", it.message.toString())
                }

                delay(1000)
                uiState.postValue(UIStates.Loading(false))
            }
        }
    }
}