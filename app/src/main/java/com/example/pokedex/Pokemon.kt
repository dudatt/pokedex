package com.example.pokedex

import retrofit2.http.Url

data class Pokemon(
    val name: String,
    val number: String,
    val type01: String,
    val type02: String?,
    val imageUrl: String?
)