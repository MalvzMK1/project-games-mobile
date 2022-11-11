package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.model.User
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

    }
}