package com.lugmana_andres.appdispo2.ui.adapter.clan


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.ItemClanLocationBinding
import com.lugmana_andres.appdispo2.ui.entity.clan.MiembroUI

class MiembrosAdapter :
    ListAdapter<MiembroUI, MiembrosAdapter.MiembrosClanVH>(DiffUtilClanMiembrosCallBack){
    class MiembrosClanVH(view : View) : RecyclerView.ViewHolder(view)  {
        private val binding = ItemClanLocationBinding.bind(view)

        fun render(item : MiembroUI){
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
            binding.txtNomClan.text = item.nombreMiem
            binding.txtTrofeosClan.text = item.trofeosMiem.toString()
            binding.txtMiemClan.text = item.roelMiem
            Log.d("Tag",item.clanRankMiem.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiembrosClanVH {
        val inflater = LayoutInflater.from(parent.context)
        return MiembrosClanVH(
            inflater.inflate(
                R.layout.item_clan_location,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MiembrosClanVH, position: Int) {
        holder.render(
            getItem(position)
        )
    }
    // Añadir la función clearList
    fun clearList() {
        submitList(emptyList())
    }



}

object DiffUtilClanMiembrosCallBack : DiffUtil.ItemCallback<MiembroUI>(){
    override fun areItemsTheSame(oldItem: MiembroUI, newItem: MiembroUI): Boolean {
        return  oldItem.nombreMiem == newItem.nombreMiem
    }

    override fun areContentsTheSame(oldItem: MiembroUI, newItem: MiembroUI): Boolean {
        return  oldItem == newItem
    }

}
