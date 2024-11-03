import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.API.PokemonRepository
import com.example.pokedex.API.SinglePokemonResponse
import com.example.pokedex.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val MIN_POKEMON_ID = 1
private const val MAX_POKEMON_ID = 151

class PokedexViewModel : ViewModel() {

    private val repository = PokemonRepository()
    private val _pokemon = MutableLiveData<List<Pokemon>>()
    val pokemon: LiveData<List<Pokemon>>
        get() = _pokemon

    fun getPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = mutableListOf<Pokemon>()

            for (i in MIN_POKEMON_ID..MAX_POKEMON_ID) {
                val response = repository.getSinglePokemon(i)
                if (response != null) {
                    val pokemon = Pokemon(
                        name = response.name ?: "Unknown",
                        number = response.id?.toString() ?: "N/A",
                        type01 = response.types.getOrNull(0)?.type?.name ?: "Unknown",
                        type02 = if (response.types.size > 1) response.types[1].type.name else null,
                        imageUrl = response.sprites.front_default ?: ""
                    )
                    data.add(pokemon)
                }
            }

            withContext(Dispatchers.Main) {
                _pokemon.postValue(data)
            }
        }
    }


}