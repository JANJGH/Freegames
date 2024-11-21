package com.example.freegames.data

import android.annotation.SuppressLint


class GamesRepository {

    val api = RetrofitInstance.getGamesApi()

    suspend fun getGamesList(): List<GamesList>? {
        return try {
            val gamesResponse = api.getGamesList()
            gamesResponse.body()
        } catch (error: Exception) {
            null
        }
    }
}