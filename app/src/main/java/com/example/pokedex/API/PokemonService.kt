package com.example.pokedex.API

import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("pokemon/{id}/")
    suspend fun getSinglePokemon(
        @Path("id") id: Int?
    ): SinglePokemonResponse
}