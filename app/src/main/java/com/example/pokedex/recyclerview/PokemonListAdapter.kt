package com.example.pokedex.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.Pokemon
import com.example.pokedex.databinding.PokemonItemBinding

class PokemonListAdapter(
    private val context: Context,
    private var pokemon: List<Pokemon> // alterado para 'var' para permitir atualização da lista
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

    override fun getItemCount(): Int = pokemon.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemon[position]
        holder.bind(pokemon)
    }

    // Função para atualizar a lista de Pokémon e notificar o RecyclerView
    fun updateList(filteredList: List<Pokemon>) {
        pokemon = filteredList
        notifyDataSetChanged() // Atualiza o RecyclerView com a nova lista
    }
}