package com.lugmana_andres.appdispo2.ui.activitys

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
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

        setImmersiveMode()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()

        // Cargar el fragmento inicial
        supportFragmentManager.beginTransaction()
            .replace(binding.containerFragments.id, PerfilFragment())
            .commit()

        // Configura los Insets para el BottomNavigationView
        ViewCompat.setOnApplyWindowInsetsListener(binding.bottomNavigation) { view, insets ->
            insets
        }
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

    private fun setImmersiveMode() {
        val decorView = window.decorView
        decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                )

        // Configura un listener para restaurar el modo inmersivo si cambia la visibilidad del sistema
        decorView.setOnSystemUiVisibilityChangeListener { visibility ->
            if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                decorView.systemUiVisibility = (
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                or View.SYSTEM_UI_FLAG_FULLSCREEN
                        )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // Configura el modo inmersivo cada vez que la actividad se reanude
        setImmersiveMode()
    }


}