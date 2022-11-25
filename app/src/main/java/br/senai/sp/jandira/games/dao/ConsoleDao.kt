package br.senai.sp.jandira.games.dao

import androidx.room.*
import br.senai.sp.jandira.games.model.Console

@Dao
interface ConsoleDao {

  @Query("SELECT * FROM tbl_console ORDER BY console_name ASC")
  fun getAllConsoles(): List<Console>

  @Query("SELECT * FROM tbl_console WHERE console_name = :name")
  fun getConsoleByName(name: String): Console

  @Query("SELECT * FROM tbl_console WHERE id_console = :id")
  fun getConsoleById(id: Int): Console

  @Insert
  fun save(console: Console): Long

  @Update
  fun update(console: Console): Int

  @Delete
  fun delete(console: Console): Int

}