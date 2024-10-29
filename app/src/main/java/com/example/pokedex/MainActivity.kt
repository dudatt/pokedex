package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedex.Pokemon
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.recyclerview.PokemonListAdapter

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PokemonListAdapter
    private val pokemonList = listOf(
        Pokemon("@drawable/charmander", "001", "Charmander", "Fire", "Fire"),
        Pokemon("@drawable/charizard", "002", "Charizard", "Fire", "Fire"),
        Pokemon("@drawable/squirtle", "003", "Squirtle", "Water", "Water"),
        Pokemon("@drawable/wartortle", "004", "Wartortle", "Water", "Water")
        // Adicione mais Pokémon conforme necessário
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura o RecyclerView
        binding.rvPokemon.layoutManager = GridLayoutManager(this, 2)
        adapter = PokemonListAdapter(this, pokemonList)
        binding.rvPokemon.adapter = adapter

        // Configura o SearchView para filtrar a lista
        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterPokemonList(newText.orEmpty())
                return true
            }
        })
    }

    // Função para filtrar a lista de Pokémon pelo nome
    private fun filterPokemonList(query: String) {
        val filteredList = pokemonList.filter { it.name.contains(query, ignoreCase = true) }
        adapter.updateList(filteredList)
    }
}
