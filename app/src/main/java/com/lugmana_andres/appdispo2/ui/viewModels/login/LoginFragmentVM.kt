package com.lugmana_andres.appdispo2.ui.viewModels.login

import android.content.Context
import android.util.Log
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

    fun authWithFirebase(
        email: String,
        password: String,
        auth: FirebaseAuth,
        context: FragmentActivity
    ) {
        viewModelScope.launch {
            uiState.postValue(UIStates.Loading(true))
            auth.signInWithEmailAndPassword(
                email, password
            )
                .addOnCompleteListener(context) { task ->
                    if (task.isSuccessful) {
                        uiState.postValue(
                            UIStates.Success(
                                true
                            )
                        )

                    } else {
                        Log.w("TAG", "signInWithEmail:failure", task.exception)
                        uiState.postValue(
                            UIStates.Error(
                                task.exception?.message.toString()
                            )
                        )
                    }
                }
            delay(500)
            uiState.postValue(UIStates.Loading(false))
        }
    }



}