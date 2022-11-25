package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.dao.MainDb
import br.senai.sp.jandira.games.model.Console

class ConsoleRepository (context: Context) {

  private val db = MainDb.getDatabase(context).consoleDao()

  fun save(console: Console): Long {
    return db.save(console)
  }

  fun delete(console: Console): Int {
    return db.delete(console)
  }

  fun update(console: Console): Int {
    return db.update(console)
  }

  fun getAllConsoles(console: Console): List<Console> {
    return db.getAllConsoles()
  }

  fun getConsoleByName(consoleName: String): Console {
    return db.getConsoleByName(consoleName)
  }

  fun getConsoleById(id: Int): Console {
    return db.getConsoleById(id)
  }

}