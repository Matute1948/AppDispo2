package com.lugmana_andres.appdispo2.ui.adapter.perfil.adapterAux

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lugmana_andres.appdispo2.ui.fragments.main.perfil.BatallasPerfilFragment
import com.lugmana_andres.appdispo2.ui.fragments.main.perfil.CartasPerfilFragment
import com.lugmana_andres.appdispo2.ui.fragments.main.perfil.EstadisticasPerfilFragment

class ViewPagerAdapter(fm: FragmentActivity, var tagAdpa : String) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int = 3 // Número de pestañas

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> EstadisticasPerfilFragment(tagAdpa) // Primer fragmento para la pestaña de estadísticas
            1 -> CartasPerfilFragment(tagAdpa) // Segundo fragmento (cambia el nombre según tu diseño)
            2 -> BatallasPerfilFragment(tagAdpa) // Tercer fragmento (cambia el nombre según tu diseño)
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}