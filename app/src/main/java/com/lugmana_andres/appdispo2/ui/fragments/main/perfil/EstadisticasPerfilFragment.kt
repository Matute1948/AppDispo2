package com.lugmana_andres.appdispo2.ui.fragments.main.perfil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.FragmentEstadisticasPerfilBinding
import com.lugmana_andres.appdispo2.ui.adapter.perfil.EstadisticasPerfilJugadorAdapter
import com.lugmana_andres.appdispo2.ui.core.ManageUIStates
import com.lugmana_andres.appdispo2.ui.viewModels.main.EstadisticasJugadorVM

class EstadisticasPerfilFragment : Fragment() {

    private lateinit var binding : FragmentEstadisticasPerfilBinding
    private val estadisticasJuadorVM : EstadisticasJugadorVM by viewModels()
    private lateinit var manageUIStates: ManageUIStates
    private lateinit var adapter : EstadisticasPerfilJugadorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEstadisticasPerfilBinding.bind(
            inflater.inflate(R.layout.fragment_estadisticas_perfil, container, false)
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
        manageUIStates = ManageUIStates(requireActivity(), binding.lytLoading.mainLayout)
        adapter = EstadisticasPerfilJugadorAdapter()
        binding.lytEstadisticas.adapter = adapter
        binding.lytEstadisticas.layoutManager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun initObservers() {
        estadisticasJuadorVM.itemEstadisticas.observe(viewLifecycleOwner) {
            it?.let {
                adapter.setItem(it)
            }
        }

        estadisticasJuadorVM.uiState.observe(viewLifecycleOwner){
            manageUIStates.invoke(it)
        }
    }

    private fun initData() {
        estadisticasJuadorVM.init("#2U20LR9U8")

    }

}