package br.senai.sp.jandira.games.dao

import android.content.Context
import androidx.room.*
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.Game
import br.senai.sp.jandira.games.model.User

@Database(entities = [User::class, Console::class, Game::class], version = 1)
abstract class GamesDb: RoomDatabase() {

  abstract fun consoleDao(): ConsoleDao
  abstract fun gameDao(): GameDao
  abstract fun userDao(): UserDao

  companion object {
    private lateinit var instance: GamesDb

    fun getDatabase(context: Context): GamesDb {
      if (!::instance.isInitialized) {
        instance = Room.databaseBuilder(
          context,
          GamesDb::class.java,
          "db_games"
        ).allowMainThreadQueries().build()
      }
      return instance
    }
  }

}