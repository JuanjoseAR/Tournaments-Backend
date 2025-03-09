package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.PokemonDTO;
import com.tournaments.tournaments.dto.PokemonMapper;
import com.tournaments.tournaments.entities.Pokemon;
import com.tournaments.tournaments.repositories.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImp implements PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;
    private final PokemonTypeService pokemonTypeService;

    public PokemonServiceImp(PokemonRepository pokemonRepository, PokemonMapper pokemonMapper, PokemonTypeService pokemonTypeService) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonMapper = pokemonMapper;
        this.pokemonTypeService = pokemonTypeService;
    }

    @Override
    public Optional<PokemonDTO> getPokemonById(Integer id) {
        return pokemonRepository.findById(id).map(pokemonMapper::toDTO);
    }

    @Override
    public List<PokemonDTO> getAllPokemons() {
        return pokemonRepository.findAll().stream()
                .map(dto->pokemonMapper.toDTO(dto)).collect(Collectors.toList());
    }

    @Override
    public PokemonDTO createPokemon(PokemonDTO pokemonDTO) {
        Pokemon newPokemon = pokemonRepository.save(pokemonMapper.toEntity(pokemonDTO, pokemonTypeService));
        return pokemonMapper.toDTO(newPokemon);
    }

    @Override
    public Optional<PokemonDTO> updatePokemonById(Integer id, PokemonDTO pokemonDTO) { //This method won't be use.
        Pokemon newPokemon = pokemonMapper.toEntity(pokemonDTO, pokemonTypeService);
        return pokemonRepository.findById(id).map(
                pokeInBD->{
                    pokeInBD.setId(newPokemon.getId());
                    return pokemonRepository.save(pokeInBD);
                }
        ).map(pokemonMapper::toDTO);
    }

    @Override
    public void deletePokemonById(Integer id) {
        pokemonRepository.deleteById(id);
    }
}
