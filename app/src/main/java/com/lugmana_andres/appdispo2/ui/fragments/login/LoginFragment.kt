package com.lugmana_andres.appdispo2.ui.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.navigation.fragment.findNavController
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.FragmentLoginBinding
import com.lugmana_andres.appdispo2.databinding.FragmentRecoveryBinding
import java.util.concurrent.Executor

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding
    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo
    private lateinit var biometricManager: BiometricManager


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
    }

    private fun initListeners() {
        binding.btnIngresar.setOnClickListener{

        }
        binding.btnRegistrarse.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }


}