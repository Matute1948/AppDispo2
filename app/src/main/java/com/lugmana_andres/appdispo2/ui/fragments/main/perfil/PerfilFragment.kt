package com.lugmana_andres.appdispo2.ui.fragments.main.perfil

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView

import androidx.fragment.app.viewModels
import coil.load
import com.google.android.material.tabs.TabLayoutMediator
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.FragmentPerfilBinding
import com.lugmana_andres.appdispo2.ui.adapter.perfil.adapterAux.ViewPagerAdapter
import com.lugmana_andres.appdispo2.ui.core.ManageUIStates
import com.lugmana_andres.appdispo2.ui.entity.perfil.BannerInfoJugadorUI
import com.lugmana_andres.appdispo2.ui.viewModels.main.BannerJugadorVM

class PerfilFragment() : Fragment() {

    private var tagPrincipal = "#2U20LR9U8"
    private lateinit var binding : FragmentPerfilBinding
    private val bannerJugadorVM : BannerJugadorVM by viewModels()
    private lateinit var manageUIStates: ManageUIStates

    companion object {
        private const val ARG_TAG_APTA = "tag_apta"

        fun newInstance(tagApta: String): PerfilFragment {
            val fragment = PerfilFragment()
            val args = Bundle()
            args.putString(ARG_TAG_APTA, tagApta)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPerfilBinding.bind(
            inflater.inflate(R.layout.fragment_perfil, container,false)
        )
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            tagPrincipal = it.getString(ARG_TAG_APTA).toString()
        }
        initVariables()
        initObservers()
        initListeners()
        initData()
        setupViewPagerAndTabs()
    }
    private fun initVariables() {
        manageUIStates = ManageUIStates(requireActivity(), binding.lytLoading.mainLayout)

    }

    private fun render(item : BannerInfoJugadorUI) {
        binding.txtTag.text = item.tagJugador
        binding.txtNameJugador.text = item.nombreJugador
        binding.txtNivel.text = item.nivelJugadir.toString()
        binding.txtClanNom.text = item.nombreClan
        binding.txtRolClan.text = item.rolClan
        binding.imagePerfil.load(item.imagen)
    }

    private fun initListeners(){

    }

    private fun initObservers() {

        bannerJugadorVM.uiState.observe(viewLifecycleOwner) {
            manageUIStates.invoke(it)
        }
        bannerJugadorVM.banner.observe(viewLifecycleOwner) { bannerInfo ->
            render(bannerInfo)
        }
    }

    private fun initData() {
        bannerJugadorVM.initData(tagPrincipal)

        Log.d("TAG", "Iniciando datos")
    }

    private fun setupViewPagerAndTabs() {
        val viewPagerAdapter = ViewPagerAdapter(requireActivity(),tagPrincipal)
        binding.lytEstadisticas.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.lytEstadisticas) { tab, position ->
            tab.text = when (position) {
                0 -> "Perfil"
                1 -> "Cartas"
                2 -> "Batallas"
                else -> throw IllegalStateException("Unexpected position $position")
            }
        }.attach()
    }
}