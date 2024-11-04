package com.example.pokedex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.databinding.ActivityFavoritesBinding
import com.example.recyclerview.PokemonAdapter

class FavoritesActivity : ComponentActivity() {
    private lateinit var binding: ActivityFavoritesBinding
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperando a lista de favoritos
        val favorites = intent.getParcelableArrayListExtra<Pokemon>("favorites") ?: emptyList()

        // Adicionando logs para verificar a lista de favoritos
        if (favorites.isEmpty()) {
            Log.d("FavoritesActivity", "A lista de favoritos está vazia.")
        } else {
            Log.d("FavoritesActivity", "Número de favoritos: ${favorites.size}")
        }

        adapter = PokemonAdapter {} // Sem callback de favorito na tela de favoritos
        binding.rvFavorites.layoutManager = LinearLayoutManager(this)
        binding.rvFavorites.adapter = adapter
        adapter.submitList(favorites)
    }
}
