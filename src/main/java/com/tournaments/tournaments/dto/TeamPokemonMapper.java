package com.tournaments.tournaments.dto;

import com.tournaments.tournaments.entities.Pokemon;
import com.tournaments.tournaments.entities.Team;
import com.tournaments.tournaments.entities.TeamPokemon;
import com.tournaments.tournaments.services.PokemonService;
import com.tournaments.tournaments.services.TeamService;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface TeamPokemonMapper {

    @Mapping(source = "team.id", target = "team")
    @Mapping(source = "pokemon.id", target = "pokemon")
    TeamPokemonDTO toDTO(TeamPokemon teamPokemon);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "team.id", target = "team")
    @Mapping(source = "pokemon.id", target = "pokemon")
    TeamPokemonDTO toDTOWithout(TeamPokemon teamPokemon);

    @Mapping(source = "team", target = "team", qualifiedByName = "idToTeam")
    @Mapping(source = "pokemon", target = "pokemon", qualifiedByName = "idToPokemon")
    TeamPokemon toEntity(TeamPokemonDTO teamPokemonDTO, @Context TeamService teamService, @Context PokemonService pokemonService);

    @Named("idToTeam")
    default Team idToTeam(String id, @Context TeamService teamService) {
        return id == null ? null : teamService.getTeamById(id).orElse(null);
    }

    @Named("idToPokemon")
    default Pokemon idToPokemon(Integer id, @Context PokemonService pokemonService) {
        return id == null ? null : pokemonService.findPokemonById(id).orElse(null);
    }
}

