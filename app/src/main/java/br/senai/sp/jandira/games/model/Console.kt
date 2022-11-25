package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.*

@Entity(tableName = "tbl_console")
data class Console(
  @ColumnInfo(name = "console_name")
  val consoleName: String,
) {
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id_console")
  var id: Int = 0
}
