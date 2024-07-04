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
import com.lugmana_andres.appdispo2.ui.core.ManageUIStates
import com.lugmana_andres.appdispo2.ui.core.UIStates
import com.lugmana_andres.appdispo2.ui.viewModels.login.RegisterFragmentVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterFragment : Fragment() {

    private lateinit var binding : FragmentRegisterBinding
    private val registerFragmentVM : RegisterFragmentVM by viewModels()
    private lateinit var managerUIStates: ManageUIStates

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
        initVariables()
        initListeners()
        initObservers()
    }

    private fun initVariables() {
        managerUIStates = ManageUIStates(requireActivity(), binding.lytLoading.mainLayout)
    }

    private fun initObservers() {
        registerFragmentVM.uiState.observe(viewLifecycleOwner) { state ->
            managerUIStates.invoke(state)
        }

    }

    private fun initListeners() {
        //poner el boton back
        binding.btnBack.setOnClickListener{
            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
        }
        binding.btnRegister.setOnClickListener{

            MaterialAlertDialogBuilder(requireActivity())//aqui van los estilos del alertdialog)
                .setTitle("Aviso")
                .setMessage("¿Está usted seguro de envíar esta información?")
                .setPositiveButton("Si"){ dialog, id ->
                    //aqui se puede poner esta seguro de guardar el usaruio y de ahi si guarda despues de poner aceptar
                    lifecycleScope.launch {
                        registerFragmentVM.saveUser(
                            binding.txtNewUser.text.toString(),
                            binding.txtNewPass.text.toString(),
                            requireContext())
                    }
                    dialog.dismiss()
                }
                .setNegativeButton("No"){ dialog, id ->
                    dialog.cancel()
                }
                .show()


        }


        //poner el boton save
    }

}