package br.senai.sp.jandira.games

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
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
}
