package com.lugmana_andres.appdispo2.ui.viewModels.login

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.lugmana_andres.appdispo2.logic.login.GetUserWithNameAndPass
import com.lugmana_andres.appdispo2.ui.core.UIStates
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginFragmentVM : ViewModel() {

    private var authGlobal : FirebaseAuth? = null
    private lateinit var contextGlobal : FragmentActivity
    var uiState = MutableLiveData<UIStates>()
    var idUser = MutableLiveData<Int>()
    fun getUserFromDB(name:String, pass:String, context : Context){

        viewModelScope.launch {
            uiState.postValue(UIStates.Loading(true))

            GetUserWithNameAndPass(context).invoke(name,pass).collect{
                it.onSuccess {
                    idUser.postValue(it.id)
                }
                it.onFailure {
                    uiState.postValue(
                        UIStates.Error(it.message.toString())
                    )
                }
            }

            delay(500)
            uiState.postValue(UIStates.Loading(false))
        }
    }

    private fun initGlobalVar(auth: FirebaseAuth, context : FragmentActivity){
        authGlobal = auth
        contextGlobal = context
    }



}