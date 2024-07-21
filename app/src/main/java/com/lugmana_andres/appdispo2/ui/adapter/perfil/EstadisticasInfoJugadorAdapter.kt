package com.lugmana_andres.appdispo2.ui.adapter.perfil


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.ItemMazoRecienteBinding
import com.lugmana_andres.appdispo2.databinding.ItemRoyalePerfilBinding
import com.lugmana_andres.appdispo2.ui.adapter.perfil.adapterAux.MazoRecurrenteAdapter
import com.lugmana_andres.appdispo2.ui.entity.perfil.EstadisticasInfoJugadorUI

class EstadisticasPerfilJugadorAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object{
        private const val VIEW_TYPE_ESTADISTICAS = 0
        private const val VIEW_TYPE_MAZORECU = 1
    }
    private var estadisticasInfo: EstadisticasInfoJugadorUI? = null

    class EstadisticasVH (view :View) : RecyclerView.ViewHolder(view){
        private val binding = ItemRoyalePerfilBinding.bind(view)
        fun render(item : EstadisticasInfoJugadorUI){
            binding.txtVictorias.text = item.numVictorias.toString()
            binding.txtDerrotas.text = item.numDerrotas.toString()
            binding.txtDonTotales.text = item.numDonacionesTotales.toString()
            binding.txtCartFavorita.text = item.cartaFavorita
            binding.txtVict3Coronas.text = item.numVictorias3Coronos.toString()
            binding.txtCartasEncontradas.text = item.cartasEncontradas.toString()
        }

    }

    class MazoRecurrenteVH(view : View) : RecyclerView.ViewHolder(view){
        private val binding = ItemMazoRecienteBinding.bind(view)
        fun render( item : EstadisticasInfoJugadorUI){
            val cartasAdapter = MazoRecurrenteAdapter(item.mazoUso)
            binding.rcMazoRec.adapter = cartasAdapter
            binding.rcMazoRec.layoutManager = GridLayoutManager(binding.rcMazoRec.context,4)
            when(item.nombreTorre){
                "Dagger Duchess" -> binding.imageView3.load(R.drawable.dagger_duchess)
                "Tower Princess" -> binding.imageView3.load(R.drawable.tower_princess)
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> VIEW_TYPE_ESTADISTICAS
            1 -> VIEW_TYPE_MAZORECU
            // Agrega más condiciones según la posición de los datos
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return if (estadisticasInfo == null) 0 else 2
    }
    fun setItem(item: EstadisticasInfoJugadorUI) {
        this.estadisticasInfo = item
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ESTADISTICAS -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_royale_perfil, parent,false)
                EstadisticasVH(view)
            }
            VIEW_TYPE_MAZORECU ->{
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_mazo_reciente, parent, false)
                MazoRecurrenteVH(view)
            }
            else -> throw IllegalArgumentException("Error view no valida")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        estadisticasInfo?.let{
            when (holder) {
                is EstadisticasVH -> holder.render(it)
                is MazoRecurrenteVH -> holder.render(it)
            }
        }
    }

}

//object DiffUtilEstadisticasPerfilCallBack : DiffUtil.ItemCallback<EstadisticasInfoJugadorUI>() {
//    override fun areItemsTheSame(
//        oldItem: EstadisticasInfoJugadorUI,
//        newItem: EstadisticasInfoJugadorUI
//    ): Boolean {
//        return oldItem.trofeos == newItem.trofeos
//    }
//
//    override fun areContentsTheSame(
//        oldItem: EstadisticasInfoJugadorUI,
//        newItem: EstadisticasInfoJugadorUI
//    ): Boolean {
//        return oldItem == newItem
//    }
//
//}
