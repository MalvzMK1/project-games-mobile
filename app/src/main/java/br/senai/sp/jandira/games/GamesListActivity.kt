package br.senai.sp.jandira.games

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import br.senai.sp.jandira.games.databinding.ActivityGamesListBinding


class GamesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGamesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_game_list, menu)

        return true
    }
}