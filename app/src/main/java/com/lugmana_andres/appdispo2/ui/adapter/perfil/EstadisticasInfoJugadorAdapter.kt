package com.lugmana_andres.appdispo2.ui.adapter.perfil


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lugmana_andres.appdispo2.R
import com.lugmana_andres.appdispo2.databinding.ItemCaminosPerfilBinding
import com.lugmana_andres.appdispo2.databinding.ItemCicloCofresPerfilBinding
import com.lugmana_andres.appdispo2.databinding.ItemLigaPerfilBinding
import com.lugmana_andres.appdispo2.databinding.ItemMazoRecientePerfilBinding
import com.lugmana_andres.appdispo2.databinding.ItemRoyalePerfilBinding
import com.lugmana_andres.appdispo2.databinding.ItemTornDesPerfilBinding
import com.lugmana_andres.appdispo2.ui.adapter.perfil.adapterAux.CicloCofresAdapter
import com.lugmana_andres.appdispo2.ui.adapter.perfil.adapterAux.MazoRecurrenteAdapter
import com.lugmana_andres.appdispo2.ui.entity.perfil.CofresJugadorUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.EstadisticasInfoJugadorUI

class EstadisticasPerfilJugadorAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object{
        private const val VIEW_TYPE_CAMINOS = 0
        private const val VIEW_TYPE_LIGA = 1
        private const val VIEW_TYPE_ESTADISTICAS = 2
        private const val VIEW_TYPE_MAZORECU = 3
        private const val VIEW_TYPE_TORNEO = 4
        private const val VIEW_TYPE_CICLO_COFRES = 5

    }
    private var estadisticasInfo: EstadisticasInfoJugadorUI? = null
    private var ciclocofresInfo : List<CofresJugadorUI> ? = null

    class CaminosVH (view :View) : RecyclerView.ViewHolder(view){
        private val binding = ItemCaminosPerfilBinding.bind(view)
        fun render(item : EstadisticasInfoJugadorUI){
            binding.txtArena.text = item.arenaCamino
            binding.txtMaxTrofeos.text = item.maxNumTrofeos.toString()
            binding.txtTrofeos.text = item.trofeos.toString()
            binding.txtArenaDuende.text = item.arenaDuende
            binding.txtTrofeosDuendes.text = item.maxNumTrofeosDuendes.toString()
            binding.txtTrofeosDuendes.text = item.trofeosDuendes.toString()
        }
    }

    class LigaVH (view :View) : RecyclerView.ViewHolder(view){
        private val binding = ItemLigaPerfilBinding.bind(view)
        private val ligaData = mapOf(
            1 to Pair("Combatientes I", R.drawable.league1),
            2 to Pair("Combatientes II", R.drawable.league2),
            3 to Pair("Combatientes III", R.drawable.league3),
            4 to Pair("Maestros I", R.drawable.league4),
            5 to Pair("Maestros II", R.drawable.league5),
            6 to Pair("Maestros III", R.drawable.league6),
            7 to Pair("Campeones", R.drawable.league7),
            8 to Pair("Grandes Campeones", R.drawable.league8),
            9 to Pair("Campeones Nobles", R.drawable.league9),
            10 to Pair("Campeones Definitivos", R.drawable.league10)
        )
        fun  render(item: EstadisticasInfoJugadorUI){
            ligaData[item.actualLiga]?.let {
                binding.txtLigaActual.text = it.first
                binding.imgLigaActual.load(it.second)
            }

            ligaData[item.anteriorLiga]?.let {
                binding.txtTemporadaAnterior.text = it.first
                binding.imgLigaAnte.load(it.second)
            }

            ligaData[item.mejorLiga]?.let {
                binding.txtMejorTemporada.text = it.first
                binding.imgLigaMejor.load(it.second)
            }

        }
    }

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
        private val binding = ItemMazoRecientePerfilBinding.bind(view)
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

    class TorneosVH(view : View) : RecyclerView.ViewHolder(view){

        private val binding = ItemTornDesPerfilBinding.bind(view)
        fun render( item: EstadisticasInfoJugadorUI){
            binding.txtVictoriasDiaGuerra.text = item.numDiaVicGuerra.toString()
            binding.txtCartasReunidasClan.text = item.cartasReunidasClan.toString()
            binding.txtTorneoJugados.text = item.numBatallasTorneos.toString()
            binding.txtTorneosGanados.text = item.maximoCartasGanadasTorneos.toString()
            binding.txtMaximoVicDes.text = item.maximoVictoriasDesafio.toString()
            binding.txtCartasGanadasDesafios.text = item.maximoCartasGanadasDesafio.toString()

        }
    }

    class CicloCofresVH(view : View) : RecyclerView.ViewHolder(view){
        private val binding = ItemCicloCofresPerfilBinding.bind(view)
        fun render( item: List<CofresJugadorUI>){
            val cofresAdapter = CicloCofresAdapter(item)
            binding.rcCicloCofres.adapter = cofresAdapter
            binding.rcCicloCofres.layoutManager = GridLayoutManager(binding.rcCicloCofres.context,4)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> VIEW_TYPE_CAMINOS
            1 -> VIEW_TYPE_LIGA
            2 -> VIEW_TYPE_ESTADISTICAS
            3 -> VIEW_TYPE_MAZORECU
            4 -> VIEW_TYPE_TORNEO
            5 -> VIEW_TYPE_CICLO_COFRES
            // Agrega más condiciones según la posición de los datos
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return if (estadisticasInfo == null && ciclocofresInfo == null) 0 else 6
    }
    fun setItem(item: EstadisticasInfoJugadorUI) {
        this.estadisticasInfo = item

        notifyDataSetChanged()
    }
    fun setItemCofres(item: List<CofresJugadorUI>) {
        this.ciclocofresInfo = item

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_CAMINOS -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_caminos_perfil, parent,false)
                CaminosVH(view)
            }
            VIEW_TYPE_LIGA -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_liga_perfil, parent,false)
                LigaVH(view)
            }
            VIEW_TYPE_ESTADISTICAS -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_royale_perfil, parent,false)
                EstadisticasVH(view)
            }
            VIEW_TYPE_MAZORECU ->{
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_mazo_reciente_perfil, parent, false)
                MazoRecurrenteVH(view)
            }
            VIEW_TYPE_TORNEO -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_torn_des_perfil, parent,false)
                TorneosVH(view)
            }
            VIEW_TYPE_CICLO_COFRES -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_ciclo_cofres_perfil, parent,false)
                CicloCofresVH(view)
            }
            else -> throw IllegalArgumentException("Error view no valida")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        estadisticasInfo?.let{
            when (holder) {
                is CaminosVH -> holder.render(it)
                is LigaVH -> holder.render(it)
                is EstadisticasVH -> holder.render(it)
                is MazoRecurrenteVH -> holder.render(it)
                is TorneosVH -> holder.render(it)
            }

            ciclocofresInfo?.let{
                when(holder){
                    is CicloCofresVH -> holder.render(it)
                }
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
