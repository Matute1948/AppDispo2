package com.lugmana_andres.appdispo2.ui.viewModels.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lugmana_andres.appdispo2.logic.main.perfil.info.GetCofresJugadorUserCase
import com.lugmana_andres.appdispo2.ui.core.UIStates
import com.lugmana_andres.appdispo2.ui.entity.perfil.CofresJugadorUI
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CicloCofresVM : ViewModel(){
    val cicloCofreVM = MutableLiveData<List<CofresJugadorUI>>()
    val uiState = MutableLiveData<UIStates>()

    fun initData(playerTag : String){
        Log.d("TAG", "Ingresando al VM Ciclo Cofre")
        viewModelScope.launch {
            uiState.postValue(UIStates.Loading(true))
            GetCofresJugadorUserCase().invoke(playerTag).collect{ respAC ->

                respAC.onSuccess {
                    cicloCofreVM.postValue(it)

                }

                respAC.onFailure {
                    uiState.postValue(UIStates.Error(it.message.toString()))
                    Log.d("TAG", it.message.toString())
                }
            }

            delay(1000)
            uiState.postValue(UIStates.Loading(false))
        }
    }

}