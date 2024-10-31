package com.example.pokedex

import PokedexViewModel
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.recyclerview.PokemonListAdapter

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PokedexViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[PokedexViewModel::class.java]
        viewModel.getPokemon()
        viewModel.pokemon.observe(this@MainActivity) { pokedex ->
            pokedex.forEach { pokemon ->
                Log.i("POKEMON", "${pokemon.name}")
            }
        }

        binding.rvPokemon.layoutManager = GridLayoutManager(this, 2)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.perfilclick.setOnClickListener {

            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}