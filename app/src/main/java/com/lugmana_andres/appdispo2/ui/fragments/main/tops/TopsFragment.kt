package com.lugmana_andres.appdispo2.ui.fragments.main.tops

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.FragmentTopsBinding
import com.lugmana_andres.appdispo2.ui.adapter.tops.TopsAdapter
import com.lugmana_andres.appdispo2.ui.core.ManageUIStates
import com.lugmana_andres.appdispo2.ui.entity.tops.TopsUI
import com.lugmana_andres.appdispo2.ui.viewModels.main.TopsVM

class TopsFragment : Fragment() {

    private lateinit var binding : FragmentTopsBinding
    private lateinit var adapter: TopsAdapter
    private lateinit var managerUIStates : ManageUIStates
    private val topsVM : TopsVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTopsBinding.bind(
            inflater.inflate(R.layout.fragment_tops, container, false)
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
        adapter = TopsAdapter { topsUI -> onPlayerClicked(topsUI) }
        binding.rcTops.adapter = adapter
        binding.rcTops.layoutManager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }
    private fun initListeners() {
        binding.btnFiltroLocalidad.setOnClickListener {
            showPopup(it, R.menu.menu_filtro_paiese)
        }
        binding.btnFiltroTrofeos.setOnClickListener {
            showPopup(it, R.menu.menu_seasons)
        }

    }

    private fun showPopup(view: View, menuRes: Int) {
        val popup = PopupMenu(requireContext(), view)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(menuRes, popup.menu)
        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.option8Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataSeason("57000017")
                    true
                }
                R.id.option9Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataSeason("57000021")
                    true
                }
                R.id.option10Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000034")
                    true
                }
                R.id.option11Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000038")
                    true
                }
                R.id.option12Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000047")
                    true
                }
                R.id.option13Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000055")
                    true
                }
                R.id.option14Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000056")
                    true
                }
                R.id.option15Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000059")
                    true
                }
                R.id.option16Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000064")
                    true
                }
                R.id.option17Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000076")
                    true
                }
                R.id.option18Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000078")
                    true
                }
                R.id.option19Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000087")
                    true
                }
                R.id.option21Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000183")
                    true
                }
                R.id.option22Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000184")
                    true
                }
                R.id.option23Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000193")
                    true
                }
                R.id.option24Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000218")
                    true
                }
                R.id.option25Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000249")
                    true
                }
                R.id.option26Pais -> {
                    // Acción para la opción 2
                    topsVM.initDataLocation("57000153")
                    true
                }
                R.id.option1Season -> {
                    topsVM.initDataSeason("97")
                    true
                }
                R.id.option2Season -> {
                    topsVM.initDataSeason("98")
                    true
                }
                R.id.option3Season -> {
                    topsVM.initDataSeason("99")
                    true
                }
                R.id.option4Season -> {
                    topsVM.initDataSeason("100")
                    true
                }
                R.id.option5Season -> {
                    topsVM.initDataSeason("101")
                    true
                }
                R.id.option6Season -> {
                    topsVM.initDataSeason("102")
                    true
                }
                R.id.option7Season -> {
                    topsVM.initDataSeason("103")
                    true
                }
                R.id.option8Season -> {
                    topsVM.initDataSeason("104")
                    true
                }
                R.id.option9Season -> {
                    topsVM.initDataSeason("105")
                    true
                }
                R.id.option10Season -> {
                    topsVM.initDataSeason("106")
                    true
                }
                R.id.option11Season -> {
                    topsVM.initDataSeason("107")
                    true
                }
                R.id.option12Season -> {
                    topsVM.initDataSeason("108")
                    true
                }
                R.id.option13Season -> {
                    topsVM.initDataSeason("109")
                    true
                }
                R.id.option14Season -> {
                    topsVM.initDataSeason("110")
                    true
                }
                R.id.option15Season -> {
                    topsVM.initDataSeason("111")
                    true
                }
                R.id.option16Season -> {
                    topsVM.initDataSeason("112")
                    true
                }
                R.id.option17Season -> {
                    topsVM.initDataSeason("113")
                    true
                }
                R.id.option18Season -> {
                    topsVM.initDataSeason("114")
                    true
                }
                R.id.option19Season -> {
                    topsVM.initDataSeason("115")
                    true
                }
                R.id.option20Season -> {
                    topsVM.initDataSeason("116")
                    true
                }
                R.id.option21Season -> {
                    topsVM.initDataSeason("117")
                    true
                }

                else -> false
            }
        }
        popup.show()
    }

    private fun initObservers() {
        topsVM.topsItem.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        topsVM.uiState.observe(viewLifecycleOwner){
            managerUIStates.invoke(it)
        }

    }

    private fun initData() {
        topsVM.initDataSeason("117")
    }

    private fun onPlayerClicked(topsUI: TopsUI) {
        showCopyDialog(topsUI)
    }

    private fun showCopyDialog(topsUI: TopsUI) {
        // Crear el diálogo
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Copiar Tag")
        builder.setMessage("Deseas copiar el tag: ${topsUI.tagTop}?")

        builder.setPositiveButton("Aceptar") { dialog, _ ->
            copyToClipboard(topsUI.tagTop)
            Toast.makeText(requireContext(), "Tag copiado: ${topsUI.tagTop}", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.dismiss()
        }

        // Mostrar el diálogo
        builder.create().show()
    }

    private fun copyToClipboard(tag: String) {
        val clipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Tag", tag)
        clipboard.setPrimaryClip(clip)
    }


}