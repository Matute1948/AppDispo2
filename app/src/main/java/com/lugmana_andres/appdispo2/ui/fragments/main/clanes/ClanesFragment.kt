package com.lugmana_andres.appdispo2.ui.fragments.main.clanes

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.DialogClanBinding
import com.lugmana_andres.appdispo2.databinding.FragmentClanesBinding
import com.lugmana_andres.appdispo2.ui.adapter.clan.ListaClanAdapter
import com.lugmana_andres.appdispo2.ui.adapter.clan.MiembrosAdapter
import com.lugmana_andres.appdispo2.ui.core.ManageUIStates
import com.lugmana_andres.appdispo2.ui.entity.clan.ClanUI
import com.lugmana_andres.appdispo2.ui.viewModels.main.ClanVM
import com.lugmana_andres.appdispo2.ui.viewModels.main.TagInfoClanVM

class ClanesFragment : Fragment() {

    private lateinit var binding : FragmentClanesBinding
    private lateinit var bindingDia: DialogClanBinding
    private val clanVM : ClanVM by viewModels()
    private val tagInfoClanVM : TagInfoClanVM by viewModels()
    private lateinit var adapter : ListaClanAdapter
    private lateinit var adapterDia: MiembrosAdapter
    private lateinit var manageUIStates: ManageUIStates
    private lateinit var manageUIStatesDia: ManageUIStates

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentClanesBinding.bind(
            inflater.inflate(R.layout.fragment_clanes, container, false)
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

        manageUIStates = ManageUIStates(requireActivity(), binding.lytLoading.mainLayout)
        adapter = ListaClanAdapter{ clanItem ->
            showDialog(clanItem)
        }
        binding.rcClanes.adapter = adapter
        binding.rcClanes.layoutManager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }
    private fun initListeners() {

    }

    private fun initObservers() {

        clanVM.clanItem.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        clanVM.uiState.observe(viewLifecycleOwner){
            manageUIStates.invoke(it)
        }
    }
    private fun initData() {
        clanVM.initData("57000011")
    }





    private fun showDialog(clanItem: ClanUI) {

        bindingDia = DialogClanBinding.inflate(layoutInflater)
        manageUIStatesDia = ManageUIStates(requireActivity(), bindingDia.lytLoading.mainLayout)
        val dialog = AlertDialog.Builder(requireContext())
            .setView(bindingDia.root)
            .create()

        //
        bindingDia.txtNomClan.text = clanItem.nombreClan
        bindingDia.txtTagClan.text = clanItem.tagClan
        bindingDia.txtDonaciones.text = clanItem.donaciones.toString()
        bindingDia.txtTipoClan.text = clanItem.clanTipo
        bindingDia.txtTrofeosClan.text = clanItem.trofeosClan.toString()
        bindingDia.txtTrofeosGuerraClan.text = clanItem.guerraClanTro.toString()

        //
        adapterDia = MiembrosAdapter()
        bindingDia.recyclerView.adapter = adapterDia
        bindingDia.recyclerView.layoutManager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.VERTICAL,
            false
        )
        tagInfoClanVM.clanTagInfo.observe(viewLifecycleOwner){
            adapterDia.submitList(it)
        }
        tagInfoClanVM.uiState.observe(viewLifecycleOwner){
            manageUIStatesDia.invoke(it)
        }

        // Inicia la carga de datos en el ViewModel
        tagInfoClanVM.initData(clanItem.tagClan) // Asume que clanItem tiene un campo "tag"


        // Configura un adapter para el RecyclerView si es necesario

        bindingDia.btnClose.setOnClickListener {
            dialog.dismiss()
        }

        dialog.setOnDismissListener {
            adapterDia.clearList()
        }

        dialog.show()


    }

}