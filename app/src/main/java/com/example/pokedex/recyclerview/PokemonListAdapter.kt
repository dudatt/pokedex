package com.example.pokedex.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.Pokemon
import com.example.pokedex.databinding.PokemonItemBinding

class PokemonListAdapter(
    //private val context: Context,
    //private val pokemon: List<Pokemon>
) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    inner class ViewHolder(private val pokemonListBinding: PokemonItemBinding) :
        RecyclerView.ViewHolder(pokemonListBinding.root) {

        fun bind(pokemon: Pokemon) {
            //pokemonListBinding.ivPokemon.text = pokemon.ImageUrl
            pokemonListBinding.tvName.text = pokemon.name
            pokemonListBinding.tvNumber.text = pokemon.number
            pokemonListBinding.tvType01.text = pokemon.type01
            pokemonListBinding.tvType02.text = pokemon.type02
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val pokemonListBinding = PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(pokemonListBinding)
    }

    override fun getItemCount() = Singleton.pokemonList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Singleton.pokemonList[position].let {
            holder.bind(it)
        }
    }
}