package br.senai.sp.jandira.games.dao

import androidx.room.*
import br.senai.sp.jandira.games.model.User

@Dao
interface UserDao {

  @Query("SELECT * FROM tbl_user ORDER BY user_name ASC")
  fun getAllUsers(): List<User>

  @Query("SELECT * FROM tbl_user WHERE id_user = :id")
  fun getUser(id: Int): User

  @Insert
  fun save(user: User): Long

  @Update
  fun update(user: User): Int

  @Delete
  fun delete(user: User): Int

}