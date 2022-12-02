package br.senai.sp.jandira.games.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.adapter.GamesAdapter
import br.senai.sp.jandira.games.databinding.ActivityGamesListBinding
import br.senai.sp.jandira.games.repository.GameRepository
import br.senai.sp.jandira.games.repository.UserRepository
import br.senai.sp.jandira.games.utils.getBitmapFromByteArray


class GamesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGamesListBinding
    lateinit var rvGames: RecyclerView
    lateinit var adapterGames: GamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameRepository = GameRepository(this)
        binding = ActivityGamesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0F

        rvGames = binding.recyclerViewGames
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterGames = GamesAdapter(this)
        adapterGames.updateGamesList(gameRepository.getAll())

        rvGames.adapter = adapterGames

        loadUserProfile()

    }

    private fun loadUserProfile() {
        val sharedPreferences = getSharedPreferences("datas", MODE_PRIVATE)
        val userId = sharedPreferences.getInt("user_id", 1)
        val userInfos = UserRepository(this).getUser(userId)

        binding.textViewUserName.text = userInfos.name
        binding.textViewUserEmail.text = userInfos.email
        binding.userProfilePhoto.setImageBitmap(getBitmapFromByteArray(userInfos.profilePhoto))
        binding.textViewUserGamerLevel.text = userInfos.gamerLevel.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_game_list, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val openNewGameActivity = Intent(this, NewGameActivity::class.java)

        if(item.itemId == R.id.menu_more) {
            startActivity(openNewGameActivity)
            return true
        }
        return true
    }

}