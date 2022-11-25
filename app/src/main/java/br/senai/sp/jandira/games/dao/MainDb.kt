package br.senai.sp.jandira.games.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.Game
import br.senai.sp.jandira.games.model.User

@Database(entities = [User::class, Console::class, Game::class], version = 1)
abstract class MainDb: RoomDatabase() {

  abstract fun consoleDao(): ConsoleDao
  abstract fun gameDao(): GameDao
  abstract fun userDao(): UserDao

  companion object {
    private lateinit var instance: MainDb

    fun getDatabase(context: Context): MainDb {
      if (!::instance.isInitialized) {
        instance = Room.databaseBuilder(
          context,
          MainDb::class.java,
          "db_app_games"
        ).allowMainThreadQueries().build()
      }
      return instance
    }
  }

}