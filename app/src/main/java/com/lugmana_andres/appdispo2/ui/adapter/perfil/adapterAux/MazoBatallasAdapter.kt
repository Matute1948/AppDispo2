package com.lugmana_andres.appdispo2.ui.adapter.perfil.adapterAux

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.ItemCartasBatallasBinding
import com.lugmana_andres.appdispo2.databinding.ItemsMazosCartasPerfilBinding
import com.lugmana_andres.appdispo2.ui.entity.perfil.MazoUsualUI

class MazoBatallasAdapter(private val cartas: List<MazoUsualUI>) :
    RecyclerView.Adapter<MazoBatallasAdapter.MazoUsualVH>(){
    class MazoUsualVH(view: View) : RecyclerView.ViewHolder(view)  {
        private val binding = ItemCartasBatallasBinding.bind(view)
        fun render(item : MazoUsualUI){
            binding.imageView2.load(item.imagen)
            binding.textLevel.text = "Nivel "+item.nivel
            binding.textElixirCost.text = item.costo.toString()
            val context = itemView.context
            when (item.calidad) {
                "common" -> {
                    binding.textLevel.setBackgroundColor(context.getColor(R.color.comun_highlight_color))
                    binding.textLevel.setTextColor(context.getColor(R.color.comun_text_color))
                }
                "rare" -> {
                    binding.textLevel.setBackgroundColor(context.getColor(R.color.especial_highlight_color))
                    binding.textLevel.setTextColor(context.getColor(R.color.especial_text_color))
                }
                "epic" -> {
                    binding.textLevel.setBackgroundColor(context.getColor(R.color.epico_highlight_color))
                    binding.textLevel.setTextColor(context.getColor(R.color.epico_text_color))
                }
                "legendary" -> {
                    val spannableString = SpannableString(binding.textLevel.text)

                    // Aplicar el color rosado al inicio
                    spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#fdd2fd")), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

                    // Aplicar el color amarillo al medio
                    spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#73fce0")), 3, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

                    // Aplicar el color verde agua al final
                    spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#8df74f")), 6, binding.textLevel.text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    binding.textLevel.text = spannableString
                    binding.textLevel.setBackgroundColor(context.getColor(R.color.legendario_highlight_color))
                }
                "champion" -> {
                    binding.textLevel.setBackgroundColor(context.getColor(R.color.campeon_highlight_color))
                    binding.textLevel.setTextColor(context.getColor(R.color.campeon_text_color))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MazoUsualVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cartas_batallas, parent, false)
        return MazoUsualVH(view)
    }

    override fun getItemCount(): Int {
        return cartas.size
    }

    override fun onBindViewHolder(holder: MazoUsualVH, position: Int) {
        holder.render(cartas[position])
    }

}