package com.lugmana_andres.appdispo2.ui.adapter.perfil.adapterAux

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.ItemCofrePerfilBinding
import com.lugmana_andres.appdispo2.ui.entity.perfil.CofresJugadorUI

class CicloCofresAdapter(private val cofre: List<CofresJugadorUI>) :
    RecyclerView.Adapter<CicloCofresAdapter.CofresVH>(){

    class CofresVH(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemCofrePerfilBinding.bind(view)
        fun render(item : CofresJugadorUI){
            binding.txtCicloCofre.text = item.ciclo.toString()
            when(item.nombreCofre){
                "Tower Troop Chest" -> binding.imageView2.load(R.drawable.tower_chest)
                "Gold Crate" -> binding.imageView2.load(R.drawable.chest_gold)
                "Golden Chest" -> binding.imageView2.load(R.drawable.chest_goldcrate)
                "Plentiful Gold Crate" -> binding.imageView2.load(R.drawable.chest_plentifulgoldcrate)
                "Magical Chest" -> binding.imageView2.load(R.drawable.chest_magical)
                "Epic Chest" -> binding.imageView2.load(R.drawable.chest_epic)
                "Giant Chest" -> binding.imageView2.load(R.drawable.chest_giant)
                "Overflowing Gold Crate" -> binding.imageView2.load(R.drawable.chest_overflowgoldcrate)
                "Mega Lightning Chest" -> binding.imageView2.load(R.drawable.chest_megalightning)
                "Royale Wild Chest" -> binding.imageView2.load(R.drawable.chest_royalwild)
                "Legendary Chest" -> binding.imageView2.load(R.drawable.chest_legendary)
                else -> binding.imageView2.load(R.drawable.chest_gold)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CofresVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cofre_perfil, parent, false)
        return CofresVH(view)
    }

    override fun getItemCount(): Int {
        return  cofre.size
    }

    override fun onBindViewHolder(holder: CofresVH, position: Int) {
        holder.render(cofre[position])
    }

}