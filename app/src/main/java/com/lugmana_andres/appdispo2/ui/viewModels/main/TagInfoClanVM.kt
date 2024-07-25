package com.lugmana_andres.appdispo2.ui.viewModels.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lugmana_andres.appdispo2.logic.main.clan.GetClanTagUserCase
import com.lugmana_andres.appdispo2.ui.core.UIStates
import com.lugmana_andres.appdispo2.ui.entity.clan.MiembroUI
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TagInfoClanVM : ViewModel(){
    val clanTagInfo = MutableLiveData<List<MiembroUI>>()
    val uiState = MutableLiveData<UIStates>()

    fun initData(clanTag: String) {
        Log.d("TAG", "Ingresando al VM Clanes")
        viewModelScope.launch {
            uiState.postValue(UIStates.Loading(true))
            GetClanTagUserCase().invoke(clanTag).collect { respAC ->
                respAC.onSuccess {
                    clanTagInfo.postValue(it)
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