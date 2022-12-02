package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.repository.UserRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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
            if(validateLogin()) {
                val openActivityGamesList = Intent(this, GamesListActivity::class.java)
                startActivity(openActivityGamesList)
            } else {
                Toast.makeText(this, "Verifique o email e a senha novamente ou crie o usuário", Toast.LENGTH_SHORT).show()
            }
        }

//        Toast.makeText(this, "TEST -> ${ConsoleRepository(this).getConsoleByName("Playstation 4")}", Toast.LENGTH_SHORT).show()

<<<<<<< HEAD
    }

    private fun validateLogin(): Boolean {
        val usersList = UserRepository(this).getAllUsers()
        usersList.forEach { user ->
            if (binding.editTextEmailLogin.text.toString() == user.email && binding.editTextPasswordLogin.text.toString() == user.password) {
                val sharedPreferences = getSharedPreferences("datas", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putInt("user_id", user.id)
                editor.commit()
                return true
            }
        }
        return false
=======
>>>>>>> 2be3973a25aa563237b3f817a99268a15128598e
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "TEST -> ${UserRepository(this).getAllUsers()}", Toast.LENGTH_SHORT).show()
    }
}