package com.lugmana_andres.appdispo2.ui.adapter.clan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.ItemClanLocationBinding
import com.lugmana_andres.appdispo2.ui.entity.clan.ClanUI

class ListaClanAdapter(private val onItemClickListener: (ClanUI) -> Unit) :
    ListAdapter<ClanUI,ListaClanAdapter.ClanVH>(DiffUtilClanCallBack){
    class ClanVH(view : View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemClanLocationBinding.bind(view)

        fun render(item : ClanUI, onItemClickListener: (ClanUI) -> Unit){
            // Asignar el número de posición
            binding.txtListClan.text = (position + 1).toString()
            // Asignar los colores de fondo según la posición
            val backgroundColor = when (position) {
                0 -> R.color.color_mostaza
                1 -> R.color.color_plomo
                2 -> R.color.color_bronce
                else -> R.color.listado
            }
            binding.txtListClan.setBackgroundColor(
                binding.txtListClan.context.getColor(backgroundColor)
            )
            binding.txtNomClan.text = item.nombreClan
            binding.txtTrofeosClan.text = item.trofeosClan.toString()
            binding.txtMiemClan.text = "Miembros: "+item.miemebrosClan.toString()
            itemView.setOnClickListener {
                onItemClickListener(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClanVH {
        val inflater = LayoutInflater.from(parent.context)
        return ClanVH(
            inflater.inflate(
                R.layout.item_clan_location,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ClanVH, position: Int) {
        holder.render(
            getItem(position), onItemClickListener
        )
    }

}

object DiffUtilClanCallBack : DiffUtil.ItemCallback<ClanUI>() {
    override fun areItemsTheSame(oldItem: ClanUI, newItem: ClanUI): Boolean {
        return oldItem.nombreClan == newItem.nombreClan
    }

    override fun areContentsTheSame(oldItem: ClanUI, newItem: ClanUI): Boolean {
        return oldItem == newItem
    }

}
