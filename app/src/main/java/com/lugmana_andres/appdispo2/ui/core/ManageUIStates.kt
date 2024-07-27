package com.lugmana_andres.appdispo2.ui.core

import android.content.Context
import android.view.View
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ManageUIStates(
    private val context : Context,
    private val view : View
) {
    fun invoke(state : UIStates){
        when(state){
            is UIStates.Loading -> {
                if(state.isLoading){
                    view.visibility = View.VISIBLE
                }else{
                    view.visibility = View.GONE
                }
            }
            is UIStates.Error -> {
                MaterialAlertDialogBuilder(
                    context
                )
                    .setTitle("Error")
                    .setMessage(state.message)
                    .setPositiveButton("Aceptar") { dialog, id ->
                        dialog.dismiss()
                    }.show()
            }
            is UIStates.Success -> {
                MaterialAlertDialogBuilder(context)//aqui van los estilos del alertdialog)
                    .setTitle("Existoso")
                    .setMessage("La operacion fue exitosa. ")
                    .setPositiveButton("Aceptar"){ dialog, id ->
                        //aqui se puede poner esta seguro de guardar el usaruio y de ahi si guarda despues de poner aceptar
                        dialog.dismiss()
                    }
                    .show()
            }
        }
    }
}