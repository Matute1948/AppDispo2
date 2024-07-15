package com.lugmana_andres.appdispo2.ui.fragments.main.cartas

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.FragmentListaAllCartasBinding
import com.lugmana_andres.appdispo2.ui.adapter.ListaAllCartasAdapter
import com.lugmana_andres.appdispo2.ui.core.ManageUIStates
import com.lugmana_andres.appdispo2.ui.viewModels.main.ListaAllCartasVM

class ListaAllCartasFragment : Fragment() {

    private lateinit var binding : FragmentListaAllCartasBinding
    private lateinit var adapter: ListaAllCartasAdapter
    private val listCartasVM: ListaAllCartasVM by viewModels()
    private lateinit var managerUIStates : ManageUIStates

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListaAllCartasBinding.bind(
            inflater.inflate(R.layout.fragment_lista_all_cartas, container, false)
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
        adapter = ListaAllCartasAdapter()
        binding.rvListCartas.adapter = adapter
        binding.rvListCartas.layoutManager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }
    private fun initListeners() {

    }
    private fun initObservers() {
        listCartasVM.itemCarta.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        listCartasVM.uiState.observe(viewLifecycleOwner) {
            managerUIStates.invoke(it)
        }

    }

    private fun initData() {
        listCartasVM.initData()
        Log.d("TAG", "Iniciando datos")
    }
}