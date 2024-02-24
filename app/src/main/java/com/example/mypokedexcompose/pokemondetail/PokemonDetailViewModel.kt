package com.example.mypokedexcompose.pokemondetail

import androidx.lifecycle.ViewModel
import com.example.mypokedexcompose.data.remote.responses.Pokemon
import com.example.mypokedexcompose.repository.PokemonRepository
import com.example.mypokedexcompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemon(pokemonName)
    }
}