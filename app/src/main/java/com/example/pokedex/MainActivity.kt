package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.recyclerview.PokemonListAdapter

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pokemonList = listOf(
            PokemonList("https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/004.png","Charmander", "N° 004", "Fire", "None"),
            PokemonList("https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/001.png","Bulbasaur", "N° 001", "Grass", "Poison"),
            PokemonList("https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/001.png","Bulbasaur", "N° 001", "Grass", "Poison"),
            PokemonList("https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/001.png","Bulbasaur", "N° 001", "Grass", "Poison"),
            PokemonList("https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/001.png","Bulbasaur", "N° 001", "Grass", "Poison"),
            PokemonList("https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/001.png","Bulbasaur", "N° 001", "Grass", "Poison"),
            PokemonList("https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/001.png","Bulbasaur", "N° 001", "Grass", "Poison"),
            PokemonList("https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/001.png","Bulbasaur", "N° 001", "Grass", "Poison"),
            PokemonList("https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/001.png","Bulbasaur", "N° 001", "Grass", "Poison"),

            )

        val adapter = PokemonListAdapter(
            context = this,
            pokemon = pokemonList
        )

        //val adapter = PokemonListAdapter(
        //   context = this,
        // pokemon = List(20) {
        //   }
        //)
        binding.rvPokemon.adapter = adapter
    }
}
