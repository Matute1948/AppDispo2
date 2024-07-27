package com.lugmana_andres.appdispo2.ui.fragments.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.FragmentLoginBinding
import com.lugmana_andres.appdispo2.ui.activitys.MainActivity
import com.lugmana_andres.appdispo2.ui.core.ManageUIStates
import com.lugmana_andres.appdispo2.ui.core.UIStates
import com.lugmana_andres.appdispo2.ui.viewModels.login.LoginFragmentVM
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding
    private lateinit var managerUIState : ManageUIStates
    private val loginFragmentVM : LoginFragmentVM by viewModels()

    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.bind(
            inflater.inflate(R.layout.fragment_login, container, false)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initVariable()
        initObservers()
    }

    private fun initVariable() {
        managerUIState = ManageUIStates(
            requireContext(),
            binding.lytLoading.mainLayout
        )
        // Initialize Firebase Auth
        auth = Firebase.auth
    }

    private fun initObservers() {
        loginFragmentVM.uiState.observe(viewLifecycleOwner) { state ->
            if (state is UIStates.Success) {
                startActivity(Intent(requireActivity(), MainActivity::class.java))
            } else {
                managerUIState.invoke(state)
            }
        }

        loginFragmentVM.idUser.observe(viewLifecycleOwner){ id ->
            startActivity(
                Intent(
                    requireActivity(),
                    MainActivity::class.java
                )
            )
            requireActivity().finish()
        }
    }

    private fun initListeners() {
        binding.btnIngresar.setOnClickListener {
            val username = binding.txtUsario.text.toString()
            val password = binding.txtPass.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                // Mostrar Snackbar si los campos están vacíos
                Snackbar.make(binding.root, "Ingrese o verifique sus datos", Snackbar.LENGTH_SHORT).show()
            } else {
                // Si los campos no están vacíos, llamar a authWithFirebase
                lifecycleScope.launch {
                    loginFragmentVM.authWithFirebase(username, password, auth, requireActivity())
                }
            }
        }

        binding.btnRegistrarse.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }


}