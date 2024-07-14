package com.lugmana_andres.appdispo2.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.ItemsAllCartasBinding
import com.lugmana_andres.appdispo2.ui.entity.clashRoyale.CartasUI

class ListaAllCartasAdapter :
    ListAdapter<CartasUI, ListaAllCartasAdapter.CartasVH>(DiffUtilCartasCallBack){
    class CartasVH(view : View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemsAllCartasBinding.bind(view)

        fun render(item: CartasUI){

            binding.cartaName.text = item.name
            binding.cartaCalidad.text = item.calidad
            binding.cartaImage.load(item.imagen)
            Log.d("IMdsgiudshgsdiuhfiusdhXDD", item.name.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartasVH {
        val inflater = LayoutInflater.from(parent.context)
        return CartasVH(
            inflater.inflate(
                R.layout.items_all_cartas,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CartasVH, position: Int) {
        holder.render(
            getItem(position)
        )
    }
}

object DiffUtilCartasCallBack : DiffUtil.ItemCallback<CartasUI>() {
    override fun areItemsTheSame(oldItem: CartasUI, newItem: CartasUI):
            Boolean {
        return oldItem.id == newItem.id

    }

    override fun areContentsTheSame(oldItem: CartasUI, newItem: CartasUI):
            Boolean {
        return oldItem == newItem
    }

}
