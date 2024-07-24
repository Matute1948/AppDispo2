package com.lugmana_andres.appdispo2.ui.fragments.main.perfil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.FragmentBatallasPerfilBinding
import com.lugmana_andres.appdispo2.ui.adapter.perfil.BatallasJugadorAdapter
import com.lugmana_andres.appdispo2.ui.adapter.perfil.ListaCartasJugadorAdapter
import com.lugmana_andres.appdispo2.ui.core.ManageUIStates
import com.lugmana_andres.appdispo2.ui.viewModels.main.BatallasJugadorVM

class BatallasPerfilFragment : Fragment() {

    private lateinit var binding: FragmentBatallasPerfilBinding
    private lateinit var adapter: BatallasJugadorAdapter
    private lateinit var managerUIStates : ManageUIStates
    private val batallasJugadorVM : BatallasJugadorVM by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBatallasPerfilBinding.bind(
            inflater.inflate(R.layout.fragment_batallas_perfil, container, false)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariables()
        initObservers()
        initData()
    }



    private fun initVariables() {
        managerUIStates = ManageUIStates(requireActivity(), binding.lytLoading.mainLayout)
        adapter = BatallasJugadorAdapter()
        binding.rcBatallasJugador.adapter = adapter
        binding.rcBatallasJugador.layoutManager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun initObservers() {
        batallasJugadorVM.batallas.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
        batallasJugadorVM.uiState.observe(viewLifecycleOwner){
            managerUIStates.invoke(it)
        }
    }


    private fun initData() {
        batallasJugadorVM.initData("#2U20LR9U8")
    }




}