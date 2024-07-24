package com.lugmana_andres.appdispo2.ui.core

import com.lugmana_andres.appdispo2.data.network.entities.batallasRecJugadorEntity.BatallasRecJugadorApiItem
import com.lugmana_andres.appdispo2.data.network.entities.cofresJugadorEntity.Item
import com.lugmana_andres.appdispo2.data.network.entities.infoJugadorEntity.Card
import com.lugmana_andres.appdispo2.data.network.entities.infoJugadorEntity.InfoJugadorAPI
import com.lugmana_andres.appdispo2.ui.entity.perfil.BannerInfoJugadorUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.BatallasJugadorUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.CofresJugadorUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.EstadisticasInfoJugadorUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.InsigniaUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.JugadorPerfilUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.MazoUsualUI
import com.lugmana_andres.appdispo2.ui.entity.perfil.RivalPerfilUI
import okhttp3.internal.notify


fun Card.toCartasUI() = MazoUsualUI (
        id = this.id,
        nombre = this.name,
        costo = this.elixirCost,
        calidad = this.rarity,
        imagen = this.iconUrls.medium,
        nivel = this.maxLevel
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

fun Item.toCofresJugadorUI() = CofresJugadorUI (
        ciclo = this.index,
        nombreCofre = this.name
)

fun BatallasRecJugadorApiItem.toBatallasJugadorUI() = BatallasJugadorUI (
        nomArena = this.arena.name,
        modoJuego = this.gameMode.name,
        liga = this.leagueNumber,
        jugador = this.team.map {
                JugadorPerfilUI(it.name,it.crowns,"XD","tagaaa", it.cards.map { car ->
                        MazoUsualUI(car.id, car.name, car.rarity, car.iconUrls.medium, car.level, car.elixirCost) }
                ,it.supportCards.get(0).name, it.supportCards.get(0).iconUrls.medium)
        },
        rival = this.opponent.map {
                RivalPerfilUI(it.name,it.tag,it.crowns,"XD","ahhh",it.cards.map { car ->
                        MazoUsualUI(car.id, car.name, car.rarity, car.iconUrls.medium, car.level, car.elixirCost) }
                ,it.supportCards.get(0).name,it.supportCards.get(0).iconUrls.medium)
        }

)
