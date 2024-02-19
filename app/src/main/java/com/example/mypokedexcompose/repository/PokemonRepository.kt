package com.example.mypokedexcompose.repository

import com.example.mypokedexcompose.data.remote.PokeApi
import com.example.mypokedexcompose.data.remote.responses.Pokemon
import com.example.mypokedexcompose.data.remote.responses.PokemonList
import com.example.mypokedexcompose.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("Unknown error occured")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemon(namePokemon: String): Resource<Pokemon> {
        val response = try {
            api.getPokemon(namePokemon)
        } catch (e: Exception) {
            return Resource.Error("Unknown error occured")
        }
        return Resource.Success(response)
    }
}