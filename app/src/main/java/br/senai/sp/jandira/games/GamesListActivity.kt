package br.senai.sp.jandira.games

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.adapter.GamesAdapter
import br.senai.sp.jandira.games.dao.GamesDao
import br.senai.sp.jandira.games.databinding.ActivityGamesListBinding


class GamesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGamesListBinding
    lateinit var rvGames: RecyclerView
    lateinit var adapterGames: GamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0F

        rvGames = binding.recyclerViewGames
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterGames = GamesAdapter(this)
        adapterGames.updateGamesList(GamesDao.getGames(this))

        rvGames.adapter = adapterGames

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_game_list, menu)

        return true
    }
}