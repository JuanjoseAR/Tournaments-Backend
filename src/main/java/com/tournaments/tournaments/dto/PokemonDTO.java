package com.tournaments.tournaments.dto;

public record PokemonDTO(
        Integer id,
        String name,
        Integer pokemonType,
        Integer level
) {}
