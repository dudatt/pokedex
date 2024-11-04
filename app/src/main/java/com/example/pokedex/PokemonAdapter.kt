package com.example.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.Pokemon
import com.example.pokedex.databinding.ItemViewBinding

class PokemonAdapter(private val onPokemonClick: (Pokemon) -> Unit) :
    ListAdapter<Pokemon, PokemonAdapter.ViewHolder>(PokemonDiffCallback()) {

    inner class ViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon) {
            binding.tvName.text = pokemon.name
            binding.tvNumber.text = pokemon.number
            binding.tvType01.text = pokemon.type01
            binding.tvType02.text = pokemon.type02

            Glide.with(binding.ivPokemon.context)
                .load(pokemon.imageUrl)
                .into(binding.ivPokemon)

            // Configurar o clique no item
            binding.root.setOnClickListener {
                // Alternar o estado de favorito
                pokemon.isFavorite = !pokemon.isFavorite

                // Log para verificar o clique e o estado do Pokémon
                Log.d("PokemonAdapter", "Clicked on ${pokemon.name}, isFavorite: ${pokemon.isFavorite}")

                // Chamar o callback para atualizar a lista de favoritos
                onPokemonClick(pokemon)

                // Não é necessário chamar notifyItemChanged, pois ListAdapter cuida disso
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.number == newItem.number // Considera 'number' como ID único do Pokémon
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem // Compara todos os campos do Pokémon
        }
    }
}
