package br.senai.sp.jandira.games.model

import androidx.room.*

@Entity(tableName = "tbl_user")
data class User(
  @ColumnInfo(name = "profile_photo")
  val profilePhoto: ByteArray,
  @ColumnInfo(name = "user_name")
  val name: String,
  val email: String,
  val password: String,
  @Embedded
  val favoriteConsole: Console?,
  val city: String,
  @ColumnInfo(name = "birth_date")
  val birthDate: String,
  @ColumnInfo(name = "gamer_level")
  val gamerLevel: GamerLevels,
  val gender: Char,
//  val games: List<Game>,
) {
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id_user")
  var id: Int = 0
}