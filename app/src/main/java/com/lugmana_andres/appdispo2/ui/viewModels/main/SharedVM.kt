package com.lugmana_andres.appdispo2.ui.viewModels.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedVM : ViewModel(){
    private val tagPrincipalItem = MutableLiveData<String>()
    val tagPrincipal: LiveData<String> get() = tagPrincipalItem

    fun setTagPrincipal(tag: String) {
        tagPrincipalItem.value = tag
    }
}