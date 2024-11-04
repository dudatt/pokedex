package com.example.pokedex

import retrofit2.http.Url
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import android.os.Parcel

data class Pokemon(
    val name: String,
    val number: String,
    val type01: String,
    val type02: String?,
    val imageUrl: String?,
    var isFavorite: Boolean = false // Atributo de favorito
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(number)
        parcel.writeString(type01)
        parcel.writeString(type02)
        parcel.writeString(imageUrl)
        parcel.writeByte(if (isFavorite) 1 else 0)
    }

    override fun describeContents(): Int = 0
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Pokemon) return false
        return number == other.number // Ou outro identificador único
    }

    override fun hashCode(): Int {
        return number.hashCode() // Ou outro identificador único
    }
    companion object CREATOR : Parcelable.Creator<Pokemon> {
        override fun createFromParcel(parcel: Parcel): Pokemon {
            return Pokemon(parcel)
        }

        override fun newArray(size: Int): Array<Pokemon?> {
            return arrayOfNulls(size)
        }
    }
}