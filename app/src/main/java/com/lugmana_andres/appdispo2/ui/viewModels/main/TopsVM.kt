package com.lugmana_andres.appdispo2.ui.viewModels.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lugmana_andres.appdispo2.logic.main.tops.GetTopForSeason
import com.lugmana_andres.appdispo2.logic.main.tops.GetTopsForLocation
import com.lugmana_andres.appdispo2.ui.core.UIStates
import com.lugmana_andres.appdispo2.ui.entity.tops.TopsUI
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TopsVM : ViewModel() {
    val topsItem  = MutableLiveData<List<TopsUI>>()
    val uiState = MutableLiveData<UIStates>()
    private var ascendente = false
    fun initDataLocation(locationId: String) {
        Log.d("TAG", "Ingresando al VM Tops Location")
        viewModelScope.launch {
            uiState.postValue(UIStates.Loading(true))
            GetTopsForLocation().invoke(locationId).collect { respAC ->
                respAC.onSuccess {
                    topsItem.postValue(it)
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
    fun initDataSeason(season: String) {
        Log.d("TAG", "Ingresando al VM tops Season")
        viewModelScope.launch {
            uiState.postValue(UIStates.Loading(true))
            GetTopForSeason().invoke(season).collect { respAC ->
                respAC.onSuccess {
                    topsItem.postValue(it)
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