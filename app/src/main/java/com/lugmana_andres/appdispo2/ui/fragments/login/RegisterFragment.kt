package com.lugmana_andres.appdispo2.ui.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.data.local.database.entities.UsersDB
import com.lugmana_andres.appdispo2.data.local.repositories.DataBaseRepository
import com.lugmana_andres.appdispo2.databinding.FragmentRegisterBinding
import com.lugmana_andres.appdispo2.logic.login.CreateUserWithNameAndPassword
import com.lugmana_andres.appdispo2.ui.core.UIStates
import com.lugmana_andres.appdispo2.ui.viewModels.login.RegisterFragmentVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterFragment : Fragment() {

    private lateinit var binding : FragmentRegisterBinding
    private val registerFragmentVM : RegisterFragmentVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.bind(
            inflater.inflate(R.layout.fragment_register, container, false)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initObservers()
    }

    private fun initObservers() {
        registerFragmentVM.uiState.observe(viewLifecycleOwner){ state ->
            when(state){
                is UIStates.Loading -> {
                    if(state.isLoading){
                        binding.lytLoading.mainLayout.visibility = View.VISIBLE
                    }else{
                        binding.lytLoading.mainLayout.visibility = View.GONE
                    }
                }
                is UIStates.Error -> {
                    MaterialAlertDialogBuilder(
                        requireActivity(),
                        com.google.android.material.R.style.ThemeOverlay_Material3_Dialog_Alert
                    )
                        .setTitle("Error")
                        .setMessage(state.message)
                        .setPositiveButton("Aceptar") { dialog, id ->
                            dialog.dismiss()
                        }
                }
                is UIStates.Success -> {
                    MaterialAlertDialogBuilder(requireActivity(), com.google.android.material.R.style.ThemeOverlay_Material3_Dialog_Alert)//aqui van los estilos del alertdialog)
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

    private fun initListeners() {
        //poner el boton back
        binding.btnBack.setOnClickListener{
            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
        }
        binding.btnRegister.setOnClickListener{

            lifecycleScope.launch {
                registerFragmentVM.saveUser(
                    binding.txtNewUser.text.toString(),
                    binding.txtNewPass.text.toString(),
                    requireContext())
            }

        }


        //poner el boton save
    }

}