package com.lugmana_andres.appdispo2.ui.core

import com.lugmana_andres.appdispo2.data.network.entities.cartas.Item
import com.lugmana_andres.appdispo2.data.network.entities.infoJugadorEntity.InfoJugadorAPI
import com.lugmana_andres.appdispo2.ui.entity.clashRoyale.CartasUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.BannerInfoJugadorUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.EstadisticasInfoJugadorUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.InsigniaUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.MazoUsualUI


fun Item.toCartasUI() = CartasUI (
        id = this.id,
        name = this.name,
        costo = this.elixirCost,
        calidad = this.rarity,
        imagen = this.iconUrls.medium
)

fun InfoJugadorAPI.toBannerInfoJugadorUI () = BannerInfoJugadorUI(
        nombreJugador = this.name,
        nivelJugadir = this.expLevel,
        nombreClan = this.clan.name,
        rolClan = this.role,
        tagJugador = this.tag,
        imagen = this.currentFavouriteCard.iconUrls.medium
)


fun InfoJugadorAPI.toEstadisticasJugadorUI() = EstadisticasInfoJugadorUI(

        maxNumTrofeos = this.bestTrophies,
        trofeos = this.trophies,
        arenaCamino = this.arena.name,
        maxNumTrofeosDuendes = this.progress.goblinRoad.bestTrophies,
        trofeosDuendes = this.progress.goblinRoad.trophies,
        arenaDuende = this.progress.goblinRoad.arena.name,
        actualLiga = this.currentPathOfLegendSeasonResult.leagueNumber,
        anteriorLiga = this.lastPathOfLegendSeasonResult.leagueNumber,
        mejorLiga = this.bestPathOfLegendSeasonResult.leagueNumber,
        insigniasPrincipales = this.badges.take(8).map {
                InsigniaUI(it.name,it.iconUrls.large)
        },
        numVictorias = this.wins,
        numDerrotas = this.losses,
        numVictorias3Coronos = this.threeCrownWins,
        cartasEncontradas = this.cards.size,
        cartaFavorita = this.currentFavouriteCard.name,
        numDonacionesTotales = this.totalDonations,
        mazoUso = this.currentDeck.map {
                MazoUsualUI(it.id,it.name,it.rarity,it.iconUrls.medium,it.level, it.elixirCost)
        },
        nombreTorre =  this.currentDeckSupportCards.get(0).name,
        calidadTorre = this.currentDeckSupportCards.get(0).rarity,
        nivelTorre = this.currentDeckSupportCards.get(0).level,
        imagenTorre = this.currentDeckSupportCards.get(0).iconUrls.medium,
        maximoVictoriasDesafio = this.challengeMaxWins,
        maximoCartasGanadasDesafio = this.challengeCardsWon,
        maximoCartasGanadasTorneos = this.tournamentCardsWon,
        numBatallasTorneos = this.tournamentBattleCount,
        numDiaVicGuerra = this.warDayWins,
        cartasReunidasClan = this.clanCardsCollected

)
