package com.lugmana_andres.appdispo2.ui.viewModels.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lugmana_andres.appdispo2.logic.main.perfil.GetCartasJugadorUserCase
import com.lugmana_andres.appdispo2.ui.core.UIStates
import com.lugmana_andres.appdispo2.ui.entity.perfil.MazoUsualUI
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CartasJugadorVM : ViewModel() {

    val cartasJugador = MutableLiveData<List<MazoUsualUI>>()
    val uiState = MutableLiveData<UIStates>()
    private var ascendente = true
    private var filtros: FilterType = FilterType.NONE

    enum class FilterType {
        NONE, LEVEL, QUALITY
    }

    fun initData(playerTag: String) {
        Log.d("TAG", "Ingresando al VM Cartas jugador")
        viewModelScope.launch {
            uiState.postValue(UIStates.Loading(true))
            GetCartasJugadorUserCase().invoke(playerTag).collect { respAC ->
                respAC.onSuccess {
                    cartasJugador.postValue(it)
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

    fun ordenarPorNivel() {
        filtros = FilterType.LEVEL
        cartasJugador.value = cartasJugador.value?.sortedWith(compareBy { it.nivel })
        if (!ascendente) {
            cartasJugador.value = cartasJugador.value?.reversed()
        }
    }

    fun ordenarPorCalidad() {
        filtros = FilterType.QUALITY
        cartasJugador.value = cartasJugador.value?.sortedWith(
            compareBy({ it.calidad }, { it.nivel })
        )
        if (!ascendente) {
            cartasJugador.value = cartasJugador.value?.reversed()
        }
    }

    fun alternarOrden() {
        ascendente = !ascendente
        when (filtros) {
            FilterType.LEVEL -> ordenarPorNivel()
            FilterType.QUALITY -> ordenarPorCalidad()
            FilterType.NONE -> cartasJugador.value = cartasJugador.value?.reversed()
        }
    }

}