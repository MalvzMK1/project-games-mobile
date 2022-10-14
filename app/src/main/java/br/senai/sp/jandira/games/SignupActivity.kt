package br.senai.sp.jandira.games

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sliderGamerLevel.setOnClickListener {
            setGamerLevel()
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
