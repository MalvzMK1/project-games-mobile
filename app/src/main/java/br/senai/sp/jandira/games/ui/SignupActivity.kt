package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivitySignupBinding
import br.senai.sp.jandira.games.model.GamerLevels
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.repository.UserRepository

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sliderGamerLevel.setOnClickListener {
            setGamerLevel()
        }

        var gamerLevel = binding.sliderGamerLevel.value
        if (gamerLevel < 25) {
            binding.textGamerLevel.text = "Noob"
        } else if (gamerLevel < 50) {
            binding.textGamerLevel.text = "Casual"
        } else if (gamerLevel < 75) {
            binding.textGamerLevel.text = "Advanced"
        } else {
            binding.textGamerLevel.text = "Competitive"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_signup, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val openMainActivity = Intent(this, MainActivity::class.java)

        if (item.itemId == R.id.menu_exit) {
            startActivity(openMainActivity)
            return true
        } else if (item.itemId == R.id.menu_save) {
            saveUser()
            startActivity(openMainActivity)
            return true
        }

        return true
    }

    private fun saveUser() {
        val userName = binding.editTextUserName.text.toString()
        val userEmail = binding.editTextUserEmail.text.toString()
        val userPassword = binding.editTextUserPassword.text.toString()
        val userCity = binding.editTextUserCity.text.toString()
        val userBirthDate = binding.editTextUserBirthdate.text.toString()
        var userGamerLevelRange = binding.sliderGamerLevel.value
        var userLevel: GamerLevels

        if (userGamerLevelRange < 25) {
            userLevel = GamerLevels.NOOB
        } else if (userGamerLevelRange < 50) {
            userLevel = GamerLevels.CASUAL
        } else if (userGamerLevelRange < 75) {
            userLevel = GamerLevels.ADVANCED
        } else {
            userLevel = GamerLevels.COMPETITIVE
        }

        val userInfos = User(0, userName, userEmail, userPassword, favoriteConsole = "Playstation", userCity, userBirthDate, userLevel, 'M')

        userRepository.save(userInfos)
        Toast.makeText(this, "Usuario salvo", Toast.LENGTH_SHORT).show()
    }

    private fun setGamerLevel() {
        val sliderGamerLevel = binding.sliderGamerLevel.value.toString().toInt()
//        Toast.makeText(this, "Hello world!", Toast.LENGTH_SHORT).show()
        if (sliderGamerLevel == 20) {
            Toast.makeText(this, "20", Toast.LENGTH_SHORT).show()
        }
    }
}
