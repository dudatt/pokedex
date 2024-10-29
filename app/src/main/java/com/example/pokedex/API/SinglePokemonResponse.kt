package com.example.pokedex.API

import com.google.gson.annotations.SerializedName

data class SinglePokemonResponse(
    @SerializedName("name") val name: String? = null,
    @SerializedName("height") val height: Int? = null,
    @SerializedName("weight") val weight: Int? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("types") val types: List<SlotType>
)

data class SlotType(
    @SerializedName("slot") val slot: Int? = null,
    @SerializedName("type") val type: Type
)

data class Type(
    @SerializedName("name") val name: String? = null,
    @SerializedName("url") val url: String? = null
)
