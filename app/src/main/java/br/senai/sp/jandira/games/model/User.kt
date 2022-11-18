package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.*
import java.time.LocalDate

@Entity(tableName = "tbl_user")
data class User(
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
//  @ColumnInfo(name = "profile_photo")
//  val profilePhoto: Bitmap? = null,
  val name: String,
  val email: String,
  val password: String,
  @ColumnInfo(name = "favorite_console")
  val favoriteConsole: String,
  val city: String,
  @ColumnInfo(name = "birth_date")
  val birthDate: String,
  @ColumnInfo(name = "gamer_level")
  val gamerLevel: GamerLevels = GamerLevels.NOOB,
  val gender: Char,
//  val games: List<Game>,
)