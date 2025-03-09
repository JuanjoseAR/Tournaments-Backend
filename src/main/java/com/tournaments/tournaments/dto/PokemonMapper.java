package com.tournaments.tournaments.dto;

import com.tournaments.tournaments.entities.Pokemon;
import com.tournaments.tournaments.entities.PokemonType;
import com.tournaments.tournaments.services.PokemonTypeService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PokemonMapper {

    @Mapping(source = "pokemonType.id", target = "pokemonType")
    PokemonDTO toDTO(Pokemon pokemon);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "pokemonType.id", target = "pokemonType")
    PokemonDTO toDTOWithoutId(Pokemon pokemon);

    @Mapping(source = "pokemonType", target = "pokemonType", qualifiedByName = "idToPokemonType")
    Pokemon toEntity(PokemonDTO pokemonDTO, @Context PokemonTypeService pokemonTypeService);

    @Named("idToPokemonType")
    default PokemonType idToPokemonType(Integer id, @Context PokemonTypeService pokemonTypeService) {
        return id == null ? null : pokemonTypeService.getPokemonTypeById(id).orElse(null);
    }
}

