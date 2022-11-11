package br.senai.sp.jandira.games.dao

import androidx.room.*
import br.senai.sp.jandira.games.model.Game

@Dao
interface GameDao {

  @Query("SELECT * FROM tbl_games ORDER BY game_name ASC")
  fun getAllGames(): List<Game>

  @Query("SELECT * FROM tbl_games WHERE id = :id")
  fun getGame(id: Int): Game

  @Insert
  fun save(game: Game): Long

  @Update
  fun update(game: Game): Int

  @Delete
  fun delete(game: Game): Int

}