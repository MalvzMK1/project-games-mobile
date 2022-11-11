package br.senai.sp.jandira.games.dao

import androidx.room.*
import br.senai.sp.jandira.games.model.User

@Dao
interface UserDao {

  @Insert
  fun save(user: User): Long

  @Update
  fun update(user: User): Int

  @Delete
  fun delete(user: User): Int

  @Query("SELECT * FROM tbl_user ORDER BY name ASC")
  fun getAllUsers(): List<User>

  @Query("SELECT * FROM tbl_user WHERE id = :id")
  fun getUser(id: Int): User

}