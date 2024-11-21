package com.example.freegames.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

   private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://www.freetogame.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getGamesApi(): GamesApi{
        return getRetrofit().create(GamesApi::class.java)
    }
}
