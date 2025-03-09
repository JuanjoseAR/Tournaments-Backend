package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.PokemonType;
import com.tournaments.tournaments.repositories.PokemonTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonTypeServiceImp implements PokemonTypeService {

    private final PokemonTypeRepository pokemonTypeRepository;

    public PokemonTypeServiceImp(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    @Override
    public Optional<PokemonType> getPokemonTypeById(Integer id) {
        return pokemonTypeRepository.findById(id);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes() {
        return pokemonTypeRepository.findAll();
    }

    @Override
    public PokemonType createPokemon(PokemonType pokemonType) {
        return pokemonTypeRepository.save(pokemonType);
    }

    @Override
    public Optional<PokemonType> updatePokemonTypeById(Integer id, PokemonType pokemonType) {
        return pokemonTypeRepository.findById(id).map(
                pokeTypeInBD->{
                    pokeTypeInBD.setName(pokemonType.getName());
                    pokeTypeInBD.setDescription(pokemonType.getDescription());


                    return pokemonTypeRepository.save(pokeTypeInBD);
                }
        );
    }

    @Override
    public void deletePokemonTypeById(Integer id) {
        pokemonTypeRepository.deleteById(id);
    }
}
