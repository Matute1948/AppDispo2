package com.lugmana_andres.appdispo2.ui.fragments.login

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
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

    private lateinit var auth: FirebaseAuth

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
        // Initialize Firebase Auth
        auth = Firebase.auth
    }

    private fun initObservers() {
        registerFragmentVM.uiState.observe(viewLifecycleOwner) { state ->
            managerUIStates.invoke(state)

            if (state is UIStates.Success) {
                Log.d(TAG, "Usuario creado con éxito")
                showUserCreatedDialog()
            } else if (state is UIStates.Error) {
                Log.d(TAG, "Error al crear usuario: ${state.message}")

            }
        }

    }


    private fun initListeners() {

        binding.btnBack.setOnClickListener{
            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
        }
        binding.btnRegister.setOnClickListener{

            validateAndShowDialog()
        }

    }

    private fun validateAndShowDialog() {
        val newUser = binding.txtNewUser.text.toString()
        val newPass = binding.txtNewPass.text.toString()
        val newPassRep = binding.txtNewPassRep.text.toString()

        if (newUser.isEmpty() || newPass.isEmpty() || newPassRep.isEmpty()) {
            // Mostrar Snackbar si alguno de los campos está vacío
            Snackbar.make(binding.root, "Ingrese o verifique sus datos", Snackbar.LENGTH_SHORT).show()
        } else if (newPass != newPassRep) {
            // Mostrar Snackbar si las contraseñas no coinciden
            Snackbar.make(binding.root, "Las contraseñas no coinciden", Snackbar.LENGTH_SHORT).show()
        } else {

            showConfirmationDialog(newUser, newPass)
        }
    }

    private fun showConfirmationDialog(newUser: String, newPass: String) {
        MaterialAlertDialogBuilder(requireActivity())
            .setTitle("Aviso")
            .setMessage("¿Está usted seguro de enviar esta información?")
            .setPositiveButton("Sí") { dialog, id ->
                registerFragmentVM.createFirebaseUser(newUser, newPass)
                dialog.dismiss()
            }
            .setNegativeButton("No") { dialog, id ->
                dialog.cancel()
            }
            .show()
    }
    private fun showUserCreatedDialog() {
        MaterialAlertDialogBuilder(requireActivity())
            .setTitle("Usuario creado")
            .setMessage("El usuario ha sido creado exitosamente.")
            .setPositiveButton("OK") { dialog, _ ->
                // Limpiar los campos de texto
                binding.txtNewUser.text.clear()
                binding.txtNewPass.text.clear()
                binding.txtNewPassRep.text.clear()
                dialog.dismiss()
            }
            .show()
    }



    private fun createLocalUser() {
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

}