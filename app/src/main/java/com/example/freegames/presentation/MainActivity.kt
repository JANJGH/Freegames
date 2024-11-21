package com.example.freegames.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.freegames.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<GamesViewModel>()

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val gameAdapter = GameAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        initRecicler()
        setColectors()
    }

    private fun initRecicler() {
        binding.gamesRecyclerView.adapter = gameAdapter
    }

    private fun setColectors() {
        lifecycleScope.launch {
            viewModel.GamesFlow.collect { gameslist ->
                gameAdapter.setGamesList(gameslist)
            }
        }
    }

}


