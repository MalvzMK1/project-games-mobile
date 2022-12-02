package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivityNewGameBinding
import br.senai.sp.jandira.games.model.Game
import br.senai.sp.jandira.games.repository.GameRepository

class NewGameActivity : AppCompatActivity() {

  lateinit var binding: ActivityNewGameBinding
  private val IMAGE_REQUEST_CODE = 101

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    binding.selectedGameImage.visibility = View.INVISIBLE

    binding.gameImageButton.setOnClickListener {
      pickImageFromGallery()
    }

  }

  private fun pickImageFromGallery() {
    val intent = Intent(Intent.ACTION_PICK)
    intent.type = "image/*"
    startActivityForResult(intent, IMAGE_REQUEST_CODE)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    val inflater = menuInflater
    inflater.inflate(R.menu.menu_new_game, menu)

    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    TODO("IMPLEMENTAR O CLIQUE NO BOTAO DE SALVAR O JOGO")
    val openGamesListActivity = Intent(this, GamesListActivity::class.java)

    if (item.itemId == R.id.menu_save_game) {
      if(validateForm()) {
        GameRepository(this).save(getForm())
      }

    }
  }

  private fun getForm(): Game {
    TODO("PEGAR AS INFORMAÇÕES DO FORMULÁRIO")
  }

  private fun validateForm(): Boolean {
    var validated = true

    val inputs = listOf(
      binding.editTextGameName,
      binding.editTextGameCompanyName,
      binding.editTextGameDescription,
      binding.editTextGameReleaseDate
    )

    inputs.forEach { input ->
      if (input.text.isEmpty()) {
        input.error = "Required fields!"
        validated = false
      }
    }

    if(binding.isFinishedRadiogroup.checkedRadioButtonId.toString().isEmpty()) {
      Toast.makeText(this, "Select one finished option", Toast.LENGTH_SHORT).show()
      validated = false
    }

    return validated
  }

}