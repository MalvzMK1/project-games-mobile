package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.dao.UserDb
import br.senai.sp.jandira.games.model.User

class UserRepository (context: Context) {

  private val db = UserDb.getDatabase(context).userDao()

  fun save (user: User): Long {
    return db.save(user)
  }

  fun update (user: User): Int {
    return db.update(user)
  }

  fun delete (user: User): Int {
    return db.delete(user)
  }

  fun getUser (id: Int): User {
    return db.getUser(id)
  }

}