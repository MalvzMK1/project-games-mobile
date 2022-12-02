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

    fun registerConsoles(db: MainDb) {
      db.consoleDao().save(Console(consoleName = "Playstation 5"))
      db.consoleDao().save(Console(consoleName = "Playstation 4"))
      db.consoleDao().save(Console(consoleName = "Playstation 3"))
      db.consoleDao().save(Console(consoleName = "Playstation 2"))
      db.consoleDao().save(Console(consoleName = "Xbox Series S/X"))
      db.consoleDao().save(Console(consoleName = "Xbox One"))
      db.consoleDao().save(Console(consoleName = "Xbox 360"))
      db.consoleDao().save(Console(consoleName = "PC"))
      db.consoleDao().save(Console(consoleName = "Outros"))
    }

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