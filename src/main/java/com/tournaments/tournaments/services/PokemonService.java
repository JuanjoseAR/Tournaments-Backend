package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.Phase;
import com.tournaments.tournaments.entities.Pokemon;

import java.util.List;
import java.util.Optional;

public interface PokemonService {
    Optional<Pokemon> getPokemonById(Integer id);
    List<Pokemon> getAllPokemons();
    Optional<Pokemon> createPokemon(Pokemon pokemon);
    Optional<Pokemon> updatePokemonById(Integer id, Pokemon pokemon);
    void deletePokemonById(Integer id);

}
