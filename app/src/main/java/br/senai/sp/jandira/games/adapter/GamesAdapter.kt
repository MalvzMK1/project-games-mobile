package br.senai.sp.jandira.games.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Games

class GamesAdapter(val context: Context): RecyclerView.Adapter<GamesAdapter.HolderGames>() {

    private var gamesList = listOf<Games>()

    fun updateGamesList(games: List<Games>) {
        this.gamesList = games
        notifyDataSetChanged()
    }

    class HolderGames(val view: View): RecyclerView.ViewHolder(view) {

        val companyNameHolder = view.findViewById<TextView>(R.id.text_view_company_name)
        val gameNameHolder = view.findViewById<TextView>(R.id.text_view_game_name)
        val descriptiomHolder = view.findViewById<TextView>(R.id.text_view_description)
        val photoHolder = view.findViewById<ImageView>(R.id.image_view_game_photo)

        fun bind(games: Games) {

            companyNameHolder.text = games.companyName
            gameNameHolder.text = games.gameName
            descriptiomHolder.text = games.description
            photoHolder.setImageDrawable(games.photo)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderGames {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.games_holder, parent, false)
        return HolderGames(view)
    }

    override fun onBindViewHolder(holder: HolderGames, position: Int) {
        holder.bind(gamesList.get(position))
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

}