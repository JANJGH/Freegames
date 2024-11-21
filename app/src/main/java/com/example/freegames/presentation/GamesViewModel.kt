package com.example.freegames.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freegames.data.GamesList
import com.example.freegames.data.GamesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GamesViewModel: ViewModel() {

    private val gamesRepository = GamesRepository()

     val GamesFlow = MutableStateFlow<List<GamesList>>(emptyList())

    init {
        getGames()
    }

     fun getGames()=viewModelScope.launch {
       val games = gamesRepository.getGamesList()?: emptyList()
        GamesFlow.emit(games)
    }

}