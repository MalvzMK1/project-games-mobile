package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.*
import java.time.LocalDate

@Entity
data class Console(
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
  val name: String,
  @ColumnInfo(name = "company_name")
  val companyName: String,
  val description: String,
  val photo: Bitmap?,
  @ColumnInfo(name = "release_date")
  val releaseDate: LocalDate,
)
