package br.senai.sp.jandira.games.dao

import androidx.room.Dao
import br.senai.sp.jandira.games.model.Game

@Dao
abstract class GameTestDao {
  companion object {
    fun getAllGames (): List<Game> {
      val game1 = Game( 0 , "Konami", "Street Fighter", "Um jogo de luta desenvolvido pela konami...", "2017-05-23", true )
      val game2 = Game( 0 , "Activision", "Warzone 2.0", "Um jogo de fps desenvolvido pela activision...", "2017-05-23", true )
      val game3 = Game( 0 , "Lorna Shore", "Pain Remains", "Literalmente o melhor álbum de deathmetal do ano...", "2017-05-23", true )

      return listOf(game1, game2, game3)
    }
  }
}