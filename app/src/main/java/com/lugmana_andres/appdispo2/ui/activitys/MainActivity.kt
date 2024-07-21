package com.lugmana_andres.appdispo2.ui.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.ActivityMainBinding
import com.lugmana_andres.appdispo2.ui.fragments.main.cartas.ListaAllCartasFragment
import com.lugmana_andres.appdispo2.ui.fragments.main.clanes.ClanesFragment
import com.lugmana_andres.appdispo2.ui.fragments.main.infor.InformacionFragment
import com.lugmana_andres.appdispo2.ui.fragments.main.perfil.PerfilFragment
import com.lugmana_andres.appdispo2.ui.fragments.main.perfil.PerfilFragmentDirections

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
        val x = supportFragmentManager.beginTransaction()
        x.replace(binding.containerFragments.id, PerfilFragment())
        x.commit()
    }

    private fun initListeners() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId){
                R.id.item_1_perfil ->{
                    val x = supportFragmentManager.beginTransaction()
                    x.replace(binding.containerFragments.id, PerfilFragment())
                    x.commit()
                    true
                }
                R.id.item_2_cartas -> {
                    val x = supportFragmentManager.beginTransaction()
                    x.replace(binding.containerFragments.id, ListaAllCartasFragment())
                    x.commit()
                    true
                }
                R.id.item_3_clanes -> {
                    val x = supportFragmentManager.beginTransaction()
                    x.replace(binding.containerFragments.id, ClanesFragment())
                    x.commit()
                    true
                }
                R.id.item_4_informacion -> {
                    val x = supportFragmentManager.beginTransaction()
                    x.replace(binding.containerFragments.id, InformacionFragment())
                    x.commit()
                    true
                }
                else -> false
            }
        }
    }


}