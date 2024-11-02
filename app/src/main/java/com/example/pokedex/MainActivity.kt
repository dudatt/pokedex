package com.example.pokedex

import PokedexViewModel
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.recyclerview.PokemonAdapter

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PokedexViewModel
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[PokedexViewModel::class.java]
        adapter = PokemonAdapter() // Criação correta do adapter

        binding.rvPokemon.layoutManager = GridLayoutManager(this, 2)
        binding.rvPokemon.adapter = adapter

        viewModel.pokemon.observe(this) { pokedex ->
            adapter.submitList(pokedex) // Atualiza os dados no adapter
        }

        viewModel.getPokemon() // Inicia a chamada para carregar os dados
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
