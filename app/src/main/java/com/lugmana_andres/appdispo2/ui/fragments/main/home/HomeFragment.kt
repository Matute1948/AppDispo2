package com.lugmana_andres.appdispo2.ui.fragments.main.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.activityViewModels
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.FragmentHomeBinding
import com.lugmana_andres.appdispo2.ui.fragments.main.perfil.PerfilFragment
import com.lugmana_andres.appdispo2.ui.viewModels.main.SharedVM

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val sharedViewModel: SharedVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.bind(inflater.inflate(R.layout.fragment_home, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListenrs()
    }

    private fun initListenrs() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    sharedViewModel.setTagPrincipal(it)
                    openAnotherFragment()
                    Log.d("SearchQuery", "Texto ingresado: $query")
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun openAnotherFragment() {
        val anotherFragment = PerfilFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.containerFragments, anotherFragment)
            .addToBackStack(null)
            .commit()
    }

}