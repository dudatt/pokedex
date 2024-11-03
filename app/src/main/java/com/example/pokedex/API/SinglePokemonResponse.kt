package com.example.pokedex.API

import com.google.gson.annotations.SerializedName

data class SinglePokemonResponse(
    @SerializedName("name") val name: String? = null,
    @SerializedName("height") val height: Int? = null,
    @SerializedName("weight") val weight: Int? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("types") val types: List<SlotType>,
    @SerializedName("sprites") val sprites: Sprites
)

data class Sprites(
    @SerializedName("front_default") val front_default: String? = null,
    @SerializedName("back_default") val back_default: String? = null,
    @SerializedName("front_shiny") val front_shiny: String? = null,
    @SerializedName("back_shiny") val back_shiny: String? = null,
)

data class SlotType(
    @SerializedName("slot") val slot: Int? = null,
    @SerializedName("type") val type: Type
)

data class Type(
    @SerializedName("name") val name: String? = null,
    @SerializedName("url") val url: String? = null
)
