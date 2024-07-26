package com.lugmana_andres.appdispo2.ui.fragments.main.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.FragmentHomeBinding
import com.lugmana_andres.appdispo2.ui.fragments.main.perfil.PerfilFragment

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
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
                // Aquí puedes manejar el texto ingresado
                openAnotherFragment("$query")
                Log.d("SearchQuery", "Texto ingresado: $query")
                // Puedes hacer algo con el texto, como iniciar una búsqueda o actualizar la UI
                return true // Devuelve true si el query ha sido manejado
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Aquí puedes manejar los cambios en el texto mientras el usuario escribe
                return false
            }
        })
    }

    private fun openAnotherFragment(tag : String) {
        val anotherFragment = PerfilFragment.newInstance(tag ?: "")
        parentFragmentManager.beginTransaction()
            .replace(R.id.containerFragments, anotherFragment) // Asegúrate de que R.id.fragment_container sea el ID del contenedor de tu fragmento
            .addToBackStack(null) // Esto es opcional, añade la transacción al back stack para permitir la navegación hacia atrás
            .commit()
    }

}