package br.senai.sp.jandira.games.model

import androidx.room.*

@Entity(tableName = "tbl_user")
data class User(
  @ColumnInfo(name = "profile_photo")
  val profilePhoto: ByteArray? = null,
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
) {
  @PrimaryKey(autoGenerate = true)
  var id: Int = 0
}