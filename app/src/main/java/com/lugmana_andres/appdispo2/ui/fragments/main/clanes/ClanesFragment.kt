package com.lugmana_andres.appdispo2.ui.fragments.main.clanes

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
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

    private lateinit var locationId : String
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
        locationId = "57000011"
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

        binding.btnFiltroTrofeos.setOnClickListener {
            showPopup(it, R.menu.menu_filtro_trrofeos)
        }
        binding.btnFiltroLocalidad.setOnClickListener {
            showPopup(it, R.menu.menu_filtro_localidad)
        }

    }

    private fun showPopup(view: View, menuRes: Int) {
        val popup = PopupMenu(requireContext(), view)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(menuRes, popup.menu)
        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.option1Loca -> {
                    // Acción para la opción 1
                    clanVM.initData("57000000")
                    true
                }
                R.id.option2Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000001")
                    true
                }
                R.id.option3Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000002")
                    true
                }
                R.id.option4Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000003")
                    true
                }
                R.id.option5Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000004")
                    true
                }
                R.id.option6Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000005")
                    true
                }
                R.id.option7Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000006")
                    true
                }
                R.id.option8Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000017")
                    true
                }
                R.id.option9Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000021")
                    true
                }
                R.id.option10Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000034")
                    true
                }
                R.id.option11Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000038")
                    true
                }
                R.id.option12Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000047")
                    true
                }
                R.id.option13Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000055")
                    true
                }
                R.id.option14Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000056")
                    true
                }
                R.id.option15Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000059")
                    true
                }
                R.id.option16Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000064")
                    true
                }
                R.id.option17Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000076")
                    true
                }
                R.id.option18Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000078")
                    true
                }
                R.id.option19Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000087")
                    true
                }
                R.id.option21Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000183")
                    true
                }
                R.id.option22Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000184")
                    true
                }
                R.id.option23Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000193")
                    true
                }
                R.id.option24Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000218")
                    true
                }
                R.id.option25Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000249")
                    true
                }
                R.id.option26Loca -> {
                    // Acción para la opción 2
                    clanVM.initData("57000153")
                    true
                }
                R.id.option1TrofeClan -> {
                    clanVM.ordenarPorTrofeosAsc()
                    true
                }
                R.id.option2TrofeClan -> {
                    clanVM.ordenarPorTrofeosDesc()
                    true
                }
                else -> false
            }
        }
        popup.show()
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
        clanVM.initData(locationId)
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