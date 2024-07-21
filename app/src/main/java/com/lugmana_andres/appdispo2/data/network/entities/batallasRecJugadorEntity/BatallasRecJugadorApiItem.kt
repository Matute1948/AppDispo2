package com.lugmana_andres.appdispo2.data.network.entities.batallasRecJugadorEntity

data class BatallasRecJugadorApiItem(
    val arena: Arena,
    val battleTime: String,
    val boatBattleSide: String,
    val boatBattleWon: Boolean,
    val challengeId: Int,
    val challengeTitle: String,
    val challengeWinCountBefore: Int,
    val deckSelection: String,
    val gameMode: GameMode,
    val isHostedMatch: Boolean,
    val isLadderTournament: Boolean,
    val leagueNumber: Int,
    val newTowersDestroyed: Int,
    val opponent: List<Opponent>,
    val prevTowersDestroyed: Int,
    val remainingTowers: Int,
    val team: List<Team>,
    val type: String
)