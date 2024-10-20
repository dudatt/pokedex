package com.example.pokedex.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.PokemonItemBinding

class PokemonListAdapter(  //talvez tenham que ser feitas alterações considerando que é um card
    private val context: Context,
    private val pokemon: List<String> // acesso a cada um dos itens(cards)
) :
    RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    class ViewHolder(private val pokemonListBinding: PokemonItemBinding) :
        RecyclerView.ViewHolder(pokemonListBinding.root) {

        fun bind(post: String) {
            pokemonListBinding.tvName.text = post // adaptar para o card
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
        val post = pokemon[position]
        holder.bind(post)
    }
}