package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.recyclerview.PokemonListAdapter
import com.example.pokedex.recyclerview.Singleton

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        for (i in 1..20) {
            Singleton.pokemonList.add(Pokemon(1,"https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/004.png","Charmander", "N° 004", "Fire", "Flying"))
        }

        setContentView(binding.root)

        binding.rvPokemon.adapter = PokemonListAdapter()
        binding.rvPokemon.layoutManager = GridLayoutManager(this, 2)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //binding.rvPokemon.adapter = adapter
    }
}
