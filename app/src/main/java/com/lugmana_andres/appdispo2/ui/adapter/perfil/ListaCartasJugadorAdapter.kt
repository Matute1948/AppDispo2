package com.lugmana_andres.appdispo2.ui.adapter.perfil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.ItemsMazosCartasPerfilBinding
import com.lugmana_andres.appdispo2.ui.entity.perfil.MazoUsualUI

class ListaCartasJugadorAdapter :
    ListAdapter<MazoUsualUI, ListaCartasJugadorAdapter.CartasJugadorVH>(DiffUtilCartasCallBack){
    class CartasJugadorVH(view : View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemsMazosCartasPerfilBinding.bind(view)

        fun render(item: MazoUsualUI){
            binding.textLevel.text = "Nivel "+item.nivel.toString()
            binding.textElixirCost.text = item.costo.toString()
            binding.imageView2.load(item.imagen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartasJugadorVH {
        val inflater = LayoutInflater.from(parent.context)
        return CartasJugadorVH(
            inflater.inflate(
                R.layout.items_mazos_cartas_perfil,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CartasJugadorVH, position: Int) {
        holder.render(
            getItem(position)
        )
    }
}

object DiffUtilCartasCallBack : DiffUtil.ItemCallback<MazoUsualUI>() {
    override fun areItemsTheSame(oldItem: MazoUsualUI, newItem: MazoUsualUI):
            Boolean {
        return oldItem.id == newItem.id

    }

    override fun areContentsTheSame(oldItem: MazoUsualUI, newItem: MazoUsualUI):
            Boolean {
        return oldItem == newItem
    }

}
