package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.*
import java.time.LocalDate

@Entity(tableName = "tbl_games")
data class Games (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "company_name")
    val companyName: String,
    @ColumnInfo(name = "game_name")
    val gameName: String,
    val description: String,
    val photo: Bitmap?,
    @ColumnInfo(name = "release_date")
    val releaseDate: LocalDate,
    val finished: Boolean,
)