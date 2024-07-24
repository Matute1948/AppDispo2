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
import com.lugmana_andres.appdispo2.databinding.FragmentCartasPerfilBinding
import com.lugmana_andres.appdispo2.databinding.FragmentListaAllCartasBinding
import com.lugmana_andres.appdispo2.databinding.ItemCaminosPerfilBinding
import com.lugmana_andres.appdispo2.ui.adapter.perfil.ListaCartasJugadorAdapter
import com.lugmana_andres.appdispo2.ui.adapter.perfil.adapterAux.CicloCofresAdapter
import com.lugmana_andres.appdispo2.ui.core.ManageUIStates
import com.lugmana_andres.appdispo2.ui.viewModels.main.CartasJugadorVM

class CartasPerfilFragment : Fragment() {

    private lateinit var binding: FragmentCartasPerfilBinding
    private lateinit var adapter: ListaCartasJugadorAdapter
    private lateinit var managerUIStates : ManageUIStates
    private val cartasJugadorVM : CartasJugadorVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartasPerfilBinding.bind(
            inflater.inflate(R.layout.fragment_cartas_perfil, container, false)
        )
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariables()
        initListeners()
        initObservers()
        initData()
    }

    private fun initVariables() {
        managerUIStates = ManageUIStates(requireActivity(), binding.lytLoading.mainLayout)
        adapter = ListaCartasJugadorAdapter()
        binding.rcCartaJugador.adapter = adapter
        binding.rcCartaJugador.layoutManager = GridLayoutManager(binding.rcCartaJugador.context,4)
    }

    private fun initListeners() {

    }
    private fun initObservers() {

        cartasJugadorVM.cartasJugador.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
        cartasJugadorVM.uiState.observe(viewLifecycleOwner){
            managerUIStates.invoke(it)
        }

    }

    private fun initData() {
        cartasJugadorVM.initData("#2U20LR9U8")
    }

}