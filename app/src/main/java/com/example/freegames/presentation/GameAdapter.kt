package com.example.freegames.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.freegames.data.GamesList
import com.example.freegames.databinding.ItemGameBinding

class GameAdapter : RecyclerView.Adapter<GameAdapter.GameViewholder>(){

    private var currentGamesList = listOf<GamesList>()

    @SuppressLint("NotifyDataSetChanged")
    fun setGamesList(newGamesList: List<GamesList>?){
        if (newGamesList != null) {
            currentGamesList = newGamesList

            notifyDataSetChanged()
        }
    }

    class GameViewholder(
        private val binding: ItemGameBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(game: GamesList) = with(binding){
            titleTextView.text = game.title
            genreTextView.text = game.genre
            Glide.with(thumbnailTextView)
                .load(game.thumbnail)
                .into(thumbnailTextView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewholder {
        return GameViewholder(
            ItemGameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: GameViewholder, position: Int) {
        holder.bind(currentGamesList[position])
    }

    override fun getItemCount() = currentGamesList.size

    }


