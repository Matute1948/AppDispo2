package com.lugmana_andres.appdispo2.ui.viewModels.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.lugmana_andres.appdispo2.logic.login.CreateUserWithNameAndPassword
import com.lugmana_andres.appdispo2.ui.core.UIStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

class RegisterFragmentVM : ViewModel() {

    var uiState = MutableLiveData<UIStates>()

    private val auth: FirebaseAuth by lazy {
        Firebase.auth
    }

    fun saveUser(name:String, pass:String, context: Context){
        viewModelScope.launch {
            uiState.postValue(UIStates.Loading(true))
            CreateUserWithNameAndPassword(context)
                .invoke(
                    name,
                    pass
                ).collect{

                    it.onSuccess{
                        uiState.postValue(UIStates.Success(it))
                    }
                    it.onFailure{
                        uiState.postValue(UIStates.Error(it.message.toString()))
                    }
                }
            delay(500)
            uiState.postValue(UIStates.Loading(false))
        }
    }


    fun createFirebaseUser(email: String, password: String) {
        uiState.postValue(UIStates.Loading(true))
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser?.isAnonymous
                    uiState.postValue(user?.let { UIStates.Success(it) })
                } else {
                    // If sign in fails, display a message to the user.
                    uiState.postValue(UIStates.Error(task.exception?.message ?: "Authentication failed."))
                }
                uiState.postValue(UIStates.Loading(false))
            }
    }
}