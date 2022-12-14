package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.*
import java.time.LocalDate

@Entity(tableName = "tbl_games")
data class Game (
    @ColumnInfo(name = "company_name")
    val companyName: String,
    @ColumnInfo(name = "game_name")
    val gameName: String,
    val description: String,
//    val photo: Bitmap? = null,
    @ColumnInfo(name = "release_date")
    val releaseDate: String,
    val finished: Boolean,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}