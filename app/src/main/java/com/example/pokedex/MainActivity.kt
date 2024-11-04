package com.example.pokedex

import PokedexViewModel
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.recyclerview.PokemonAdapter

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PokedexViewModel
    private lateinit var adapter: PokemonAdapter
    private val favoritePokemonList = mutableListOf<Pokemon>() // Lista de favoritos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[PokedexViewModel::class.java]

        adapter = PokemonAdapter { pokemon ->
            // Log para verificar o clique
            Log.d("MainActivity", "Clicado em: ${pokemon.name}, isFavorite: ${pokemon.isFavorite}")

            // Alternar o estado de favorito
            pokemon.isFavorite = !pokemon.isFavorite

            if (pokemon.isFavorite) {
                // Se for favorito agora, adicione à lista
                favoritePokemonList.remove(pokemon)
                Log.d("MainActivity", "${pokemon.name} adicionado aos favoritos.")
            } else {
                // Se não for favorito agora, remova da lista
                favoritePokemonList.add(pokemon)
                Log.d("MainActivity", "${pokemon.name} removido dos favoritos.")
            }

            // Log para verificar o conteúdo da lista de favoritos
            Log.d("MainActivity", "Favoritos atuais: $favoritePokemonList")
        }

        binding.rvPokemon.layoutManager = GridLayoutManager(this, 2)
        binding.rvPokemon.adapter = adapter

        viewModel.pokemon.observe(this) { pokedex ->
            adapter.submitList(pokedex) // Enviar a nova lista de Pokémon para o adapter
        }

        viewModel.getPokemon()

        binding.favoriteButton.setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java)
            intent.putParcelableArrayListExtra("favorites", ArrayList(favoritePokemonList))
            startActivity(intent)
        }
    }
}

