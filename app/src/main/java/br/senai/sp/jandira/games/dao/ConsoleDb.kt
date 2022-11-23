package br.senai.sp.jandira.games.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.Game
import br.senai.sp.jandira.games.model.User

@Database(entities = [User::class, Console::class, Game::class], version = 1)
abstract class ConsoleDb: RoomDatabase() {

  abstract fun consoleDao(): ConsoleDao

  companion object {
    private lateinit var instance: ConsoleDb

    fun getDatabase(context: Context): ConsoleDb {
      if (!::instance.isInitialized) {
        instance = Room.databaseBuilder(
          context,
          ConsoleDb::class.java,
          "db_console"
        ).allowMainThreadQueries().build()
      }
      return instance
    }
  }

}