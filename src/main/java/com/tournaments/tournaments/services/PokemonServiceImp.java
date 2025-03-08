package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.Pokemon;
import com.tournaments.tournaments.repositories.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonServiceImp implements PokemonService {

    private PokemonRepository pokemonRepository;

    public PokemonServiceImp(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public Optional<Pokemon> getPokemonById(Integer id) {
        return pokemonRepository.findById(id);
    }

    @Override
    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    @Override
    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @Override
    public Optional<Pokemon> updatePokemonById(Integer id, Pokemon pokemon) { //This method won't be use.
        return pokemonRepository.findById(id).map(
                pokeInBD->{
                    pokemon.setId(pokeInBD.getId());
                    return pokemonRepository.save(pokemon);
                }
        );
    }

    @Override
    public void deletePokemonById(Integer id) {
        pokemonRepository.deleteById(id);
    }
}
