package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.dao.GameTestDao
import br.senai.sp.jandira.games.dao.GamesDb
import br.senai.sp.jandira.games.model.Game

class GameRepository (context: Context) {

  private val db = GamesDb.getDatabase(context).gameDao()

  fun save (game: Game): Long {
    return db.save(game)
  }

  fun update (game: Game): Int {
    return db.update(game)
  }

  fun delete (game: Game): Int {
    return db.delete(game)
  }

  fun getAll (): List<Game> {
    return GameTestDao.getAllGames()
  }

  fun getGameById(gameId: Int): Game {
    return db.getGame(gameId)
  }

}