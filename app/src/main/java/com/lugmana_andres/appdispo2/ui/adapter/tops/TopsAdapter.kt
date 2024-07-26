package com.lugmana_andres.appdispo2.ui.adapter.tops

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.ItemClanLocationBinding
import com.lugmana_andres.appdispo2.ui.entity.tops.TopsUI

class TopsAdapter :
    ListAdapter<TopsUI, TopsAdapter.TopsVH>(DiffUtilTopsCallBack){
    class TopsVH(view : View) : RecyclerView.ViewHolder(view){
        private val binding = ItemClanLocationBinding.bind(view)
        fun render(item : TopsUI){
            binding.txtListClan.text = (position + 1).toString()
            val backgroundColor = when (position) {
                0 -> R.color.color_mostaza
                1 -> R.color.color_plomo
                2 -> R.color.color_bronce
                else -> R.color.listado
            }
            binding.txtListClan.setBackgroundColor(
                binding.txtListClan.context.getColor(backgroundColor)
            )
            binding.txtNomClan.text = item.nombreTop
            binding.txtMiemClan.text = item.nomClanTop
            binding.txtTrofeosClan.text = item.rankgTop.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopsVH {
        val inflater = LayoutInflater.from(parent.context)
        return TopsVH(
            inflater.inflate(
                R.layout.item_clan_location,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TopsVH, position: Int) {
       holder.render(
           getItem(position)
       )
    }

}

object DiffUtilTopsCallBack : DiffUtil.ItemCallback<TopsUI>() {
    override fun areItemsTheSame(oldItem: TopsUI, newItem: TopsUI): Boolean {
        return oldItem.nombreTop == newItem.nombreTop
    }

    override fun areContentsTheSame(oldItem: TopsUI, newItem: TopsUI): Boolean {
        return oldItem == newItem
    }

}
