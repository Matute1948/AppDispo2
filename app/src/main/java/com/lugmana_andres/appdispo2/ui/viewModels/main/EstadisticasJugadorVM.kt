package com.lugmana_andres.appdispo2.ui.viewModels.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lugmana_andres.appdispo2.logic.main.perfil.GetInfoJugadorUserCase
import com.lugmana_andres.appdispo2.ui.core.UIStates
import com.lugmana_andres.appdispo2.ui.entity.perfil.EstadisticasInfoJugadorUI
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EstadisticasJugadorVM : ViewModel(){
    val itemEstadisticas = MutableLiveData<EstadisticasInfoJugadorUI>()
    val uiState = MutableLiveData<UIStates>()

    fun init(playerTag : String){
        Log.d("TAG", "Ingresando al VM Estadisticas")
        viewModelScope.launch {
            uiState.postValue(UIStates.Loading(true))
            GetInfoJugadorUserCase().invoke(playerTag).collect{
                it.onSuccess {
                    itemEstadisticas.postValue(it)
                }

                it.onFailure {
                    uiState.postValue(UIStates.Error(it.message.toString()))
                    Log.d("TAG", it.message.toString())
                }
            }

            delay(1000)
            uiState.postValue(UIStates.Loading(false))

        }
    }

}