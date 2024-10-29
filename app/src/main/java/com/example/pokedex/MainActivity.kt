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

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()

        setContentView(binding.root)

        //binding.rvPokemon.adapter = PokemonListAdapter()
        binding.rvPokemon.layoutManager = GridLayoutManager(this, 2)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val adapter = PokemonListAdapter(
            context = this,
            pokemon = List(20) {
                Pokemon("@drawable/charmander", "001", "Charmander", "Fire", "Fire")
                Pokemon("@drawable/charizard", "002", "Charizard", "Fire", "Fire")
                Pokemon("@drawable/squirtle", "003", "Squirtle", "Water", "Water")
                Pokemon("@drawable/wartortle", "004", "Wartortle", "Water", "Water")
            }
        )
        binding.rvPokemon.adapter = adapter
    }
}
