package br.senai.sp.jandira.games.dao

import androidx.room.*
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.Games
import br.senai.sp.jandira.games.model.User

@Database(entities = [User::class, Console::class, Games::class], version = 1)
class GamesDb: RoomDatabase() {

}