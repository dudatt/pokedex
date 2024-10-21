package com.example.pokedex.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.PokemonList
import com.example.pokedex.R
import com.example.pokedex.databinding.PokemonItemBinding

class PokemonListAdapter(
    private val context: Context,
    private val pokemon: List<PokemonList> // acesso a cada um dos itens(cards)
) :
    RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    class ViewHolder(private val pokemonListBinding: PokemonItemBinding) :
        RecyclerView.ViewHolder(pokemonListBinding.root) {

        fun bind(pokemon: PokemonList) {
            //pokemonListBinding.ivPokemon = pokemon.image
            pokemonListBinding.tvName.text = pokemon.name
            pokemonListBinding.tvNumber.text = pokemon.number
            pokemonListBinding.tvType01.text = pokemon.type01
            pokemonListBinding.tvType02.text = pokemon.type02
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder = ViewHolder(
        PokemonItemBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = pokemon.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemon[position]
        holder.bind(pokemon)
    }
}