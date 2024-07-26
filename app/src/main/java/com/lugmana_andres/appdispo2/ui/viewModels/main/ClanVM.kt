package com.lugmana_andres.appdispo2.ui.viewModels.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lugmana_andres.appdispo2.logic.main.clan.GetClanLocationIdUserCase
import com.lugmana_andres.appdispo2.ui.core.UIStates
import com.lugmana_andres.appdispo2.ui.entity.clan.ClanUI
import com.lugmana_andres.appdispo2.ui.viewModels.main.CartasJugadorVM.FilterType
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ClanVM : ViewModel() {
    val clanItem = MutableLiveData<List<ClanUI>>()
    val uiState = MutableLiveData<UIStates>()
    private var ascendente = false

    fun initData(locationId: String) {
        Log.d("TAG", "Ingresando al VM Clanes")
        viewModelScope.launch {
            uiState.postValue(UIStates.Loading(true))
            GetClanLocationIdUserCase().invoke(locationId).collect { respAC ->
                respAC.onSuccess {
                    clanItem.postValue(it)
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
    fun ordenarPorTrofeosAsc() {

        clanItem.value = clanItem.value?.sortedWith(compareBy { it.trofeosClan })
        if (!ascendente) {
            clanItem.value = clanItem.value?.reversed()
        }
    }
    fun ordenarPorTrofeosDesc() {

        clanItem.value = clanItem.value?.sortedWith(compareBy { it.trofeosClan })
        if (ascendente) {
            clanItem.value = clanItem.value?.reversed()
        }
    }

}