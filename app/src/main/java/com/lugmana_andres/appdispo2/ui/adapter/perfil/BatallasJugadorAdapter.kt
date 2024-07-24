package com.lugmana_andres.appdispo2.ui.adapter.perfil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.ItemBatallasRecientesPerfilBinding
import com.lugmana_andres.appdispo2.ui.adapter.perfil.adapterAux.MazoBatallasAdapter
import com.lugmana_andres.appdispo2.ui.adapter.perfil.adapterAux.MazoRecurrenteAdapter
import com.lugmana_andres.appdispo2.ui.entity.perfil.BatallasJugadorUI


class BatallasJugadorAdapter :
    ListAdapter<BatallasJugadorUI, BatallasJugadorAdapter.BatallasVH>(DiffUtilBatallasCallBack){
    class BatallasVH(view : View) : RecyclerView.ViewHolder(view){
        private val binding = ItemBatallasRecientesPerfilBinding.bind(view)
        private val torres = mapOf(
            "Dagger Duchess" to (R.drawable.dagger_duchess),
            "Tower Princess" to (R.drawable.tower_princess),
            "Baby Goblins" to (R.drawable.duendes_bebes),
            "Cannoneer" to (R.drawable.canonero)
        )
        fun render(item : BatallasJugadorUI){

            val context = binding.root.context  // Obtener el contexto desde la vista raíz
            val adapterJugador = MazoBatallasAdapter(item.jugador.get(0).cartasJugador)
            val adapterRival = MazoBatallasAdapter(item.rival.get(0).cartasRival)
            binding.txtNameJugador.text = item.jugador[0].nombreJuga
            binding.txtClanJugador.text = item.jugador[0].nombreClan
            binding.txtNumCoroJuga.text = item.jugador[0].nomCoronasJuga.toString()
            binding.txtNameRival.text = item.rival[0].nomRival
            binding.txtClanRival.text = item.rival[0].nomClan
            binding.txtNumCoroRival.text = item.rival[0].numCoronasRiva.toString()
            if (item.jugador[0].nomCoronasJuga>item.rival[0].numCoronasRiva){
                binding.txtResultado.text = "Victoria"
                binding.txtResultado.setTextColor(ContextCompat.getColor(context,R.color.blue))
            }else{
                binding.txtResultado.text = "Derrota"
                binding.txtResultado.setTextColor(ContextCompat.getColor(context, R.color.red))
            }
            torres[item.jugador.get(0).nomTorreJuga]?.let {
                binding.imgTorreJugador.load(it)
            }
            torres[item.rival.get(0).nomTorre]?.let {
                binding.imgTorreRival.load(it)
            }
            binding.rcMazoJuga.adapter = adapterJugador
            binding.rcMazoJuga.layoutManager = GridLayoutManager(binding.rcMazoJuga.context,4)
            binding.rcMazoRival.adapter = adapterRival
            binding.rcMazoRival.layoutManager = GridLayoutManager(binding.rcMazoRival.context,4)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatallasVH {
        val inflater = LayoutInflater.from(parent.context)
        return BatallasVH(
            inflater.inflate(
            R.layout.item_batallas_recientes_perfil,
            parent,
            false
            )
        )
    }

    override fun onBindViewHolder(holder: BatallasVH, position: Int) {
        holder.render(
            getItem(position)
        )
    }
}

object DiffUtilBatallasCallBack : DiffUtil.ItemCallback<BatallasJugadorUI>() {
    override fun areItemsTheSame(oldItem: BatallasJugadorUI, newItem: BatallasJugadorUI): Boolean {
        return oldItem.rival.get(0).nomRival == newItem.rival.get(0).nomRival
    }

    override fun areContentsTheSame(
        oldItem: BatallasJugadorUI,
        newItem: BatallasJugadorUI
    ): Boolean {
        return oldItem == newItem
    }

}
