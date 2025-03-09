package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.PokemonDTO;

import java.util.List;
import java.util.Optional;

public interface PokemonService {
    Optional<PokemonDTO> getPokemonById(Integer id);
    List<PokemonDTO> getAllPokemons();
    PokemonDTO createPokemon(PokemonDTO pokemonDTO);
    Optional<PokemonDTO> updatePokemonById(Integer id, PokemonDTO pokemonDTO);
    void deletePokemonById(Integer id);

}
