package com.lugmana_andres.appdispo2.ui.adapter.perfil.adapterAux

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.ItemsMazosCartasBinding
import com.lugmana_andres.appdispo2.ui.entity.perfil.MazoUsualUI

class MazoRecurrenteAdapter(private val cartas: List<MazoUsualUI>) :
    RecyclerView.Adapter<MazoRecurrenteAdapter.MazoUsualVH>(){
    class MazoUsualVH(view: View) : RecyclerView.ViewHolder(view)  {
        private val binding = ItemsMazosCartasBinding.bind(view)
        fun render(item : MazoUsualUI){
            binding.imageView2.load(item.imagen)
            binding.textLevel.text = "Nivel "+item.nivel
            binding.textElixirCost.text = item.costo.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MazoUsualVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_mazos_cartas, parent, false)
        return MazoUsualVH(view)
    }

    override fun getItemCount(): Int {
        return cartas.size
    }

    override fun onBindViewHolder(holder: MazoUsualVH, position: Int) {
        holder.render(cartas[position])
    }

}