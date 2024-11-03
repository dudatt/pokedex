package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.Pokemon
import com.example.pokedex.databinding.ItemViewBinding

class PokemonAdapter : ListAdapter<Pokemon, PokemonAdapter.ViewHolder>(PokemonDiffCallback()) {

    inner class ViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon) {
            binding.tvName.text = pokemon.name
            binding.tvNumber.text = pokemon.number
            binding.tvType01.text = pokemon.type01
            binding.tvType02.text = pokemon.type02
            Glide.with(binding.ivPokemon.context)
                .load(pokemon.imageUrl)
                .into(binding.ivPokemon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)) // Use getItem para obter o Pokémon na posição correta
    }

    class PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.number == newItem.number // Aqui você pode usar um ID único
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }
}
