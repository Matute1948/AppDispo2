package com.lugmana_andres.appdispo2.ui.viewModels.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lugmana_andres.appdispo2.logic.main.GetAllCartasUserCase
import com.lugmana_andres.appdispo2.ui.core.UIStates
import com.lugmana_andres.appdispo2.ui.entity.clashRoyale.CartasUI
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListaAllCartasVM : ViewModel(){
    val itemCarta = MutableLiveData<List<CartasUI>>()
    val uiState = MutableLiveData<UIStates>()

    fun initData(){
        Log.d("TAG", "Ingresando al VM")
        viewModelScope.launch {
            uiState.postValue(UIStates.Loading(true))
            GetAllCartasUserCase().invoke().collect{respAC ->
                respAC.onSuccess { items ->
                    itemCarta.postValue(items)
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