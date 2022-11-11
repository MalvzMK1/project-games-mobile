package br.senai.sp.jandira.games.dao

import android.content.Context
import br.senai.sp.jandira.games.model.Games
import java.time.LocalDate

class GamesDao {

    companion object {

        fun getGames(context: Context): List<Games> {
            val game1 = Games(
                id = 1,
                companyName = "Capcom",
                gameName = "Street Fighter",
                description = "Street Fighter, popularmente abreviado para SF, é uma popular série de jogos de luta.",
                photo = null,
                releaseDate = LocalDate.now(),
                finished = true
            )

            val game2 = Games(
                id = 2,
                companyName = "Konami",
                gameName = "Ninja Turtles II",
                description = "Teenage Mutant Ninja Turtles: Shredder's Revenge é um jogo eletrônico beat 'em up desenvolvido pela Tribute Games.",
                photo = null,
                releaseDate = LocalDate.now(),
                finished = false
            )

            val game3 = Games(
                id = 3,
                companyName = "Lorna Shore",
                gameName = "Pain Remains",
                description = "Lorna Shore é uma banda americana de deathcore originada do Condado de Warren, em Nova Jérsei. Formado em 2010, o grupo atualmente é formado pelo guitarrista Adam De Micco, o baterista Austin Archey, o guitarrista base Andrew O'Connor e pelo vocalista Will Ramos.",
                photo = null,
                releaseDate = LocalDate.now(),
                finished = true
            )

            val games = listOf(game1, game2, game3)

            return games
        }
    }
}