package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.repository.ConsoleRepository
import br.senai.sp.jandira.games.repository.UserRepository
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.createAccountButton.setOnClickListener {
            val openActivitySignup = Intent(this, SignupActivity::class.java)
            startActivity(openActivitySignup)
        }

        binding.enterButton.setOnClickListener {
            val openActivityGamesList = Intent(this, GamesListActivity::class.java)
            startActivity(openActivityGamesList)
        }

        Toast.makeText(this, "TESTE -> ${ConsoleRepository(this).getConsoleByName("Playstation 4")}", Toast.LENGTH_SHORT).show()

        ConsoleRepository(this).save(Console(consoleName = "Playstation 4"))
        ConsoleRepository(this).save(Console(consoleName = "Playstation 5"))
        ConsoleRepository(this).save(Console(consoleName = "Playstation 3"))
        ConsoleRepository(this).save(Console(consoleName = "Playstation 2"))
        ConsoleRepository(this).save(Console(consoleName = "Atari"))
        ConsoleRepository(this).save(Console(consoleName = "PC"))
        ConsoleRepository(this).save(Console(consoleName = "Xbox Series S/X"))
        ConsoleRepository(this).save(Console(consoleName = "Xbox 360"))
        ConsoleRepository(this).save(Console(consoleName = "Nintendo Switch"))
        ConsoleRepository(this).save(Console(consoleName = "Nintendo 64"))
        ConsoleRepository(this).save(Console(consoleName = "Xbox One"))

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "TESTE -> ${UserRepository(this).getAllUsers()}", Toast.LENGTH_SHORT).show()
    }
}