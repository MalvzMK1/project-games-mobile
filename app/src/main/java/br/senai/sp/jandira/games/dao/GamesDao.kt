package br.senai.sp.jandira.games.dao

import android.content.Context
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Games

class GamesDao {

    companion object {

        fun getGames(context: Context): List<Games> {
            val game1 = Games()
            game1.id = 1
            game1.companyName = "Capcom"
            game1.gameName = "Street Fighter"
            game1.description = "Street Fighter, popularmente abreviado para SF, é uma popular série de jogos de luta."
            game1.photo = context.getDrawable(R.drawable.image1)

            val game2 = Games()
            game2.id = 2
            game2.companyName = "Konami"
            game2.gameName = "Ninja Turtles II"
            game2.description = "Teenage Mutant Ninja Turtles: Shredder's Revenge é um jogo eletrônico beat 'em up desenvolvido pela Tribute Games."
            game2.photo = context.getDrawable(R.drawable.image2)

            val game3 = Games()
            game3.id = 3
            game3.companyName = "Lorna Shore"
            game3.gameName = "Pain Remains"
            game3.description = "Lorna Shore é uma banda americana de deathcore originada do Condado de Warren, em Nova Jérsei. Formado em 2010, o grupo atualmente é formado pelo guitarrista Adam De Micco, o baterista Austin Archey, o guitarrista base Andrew O'Connor e pelo vocalista Will Ramos."
            game3.photo = context.getDrawable(R.drawable.lorna_shore)

            val games = listOf<Games>(game1, game2, game3)

            return games
        }
    }
}