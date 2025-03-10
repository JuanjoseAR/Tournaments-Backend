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

    @Mapping(source = "team.id", target = "teamId")
    @Mapping(source = "pokemon.id", target = "pokemonId")
    TeamPokemonDTO toDTO(TeamPokemon teamPokemon);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "team.id", target = "teamId")
    @Mapping(source = "pokemon.id", target = "pokemonId")
    TeamPokemonDTO toDTOWithoutId(TeamPokemon teamPokemon);

    @Mapping(source = "teamId", target = "team", qualifiedByName = "idToTeam")
    @Mapping(source = "pokemonId", target = "pokemon", qualifiedByName = "idToPokemon")
    TeamPokemon toEntity(TeamPokemonDTO teamPokemonDTO, @Context TeamService teamService, @Context PokemonService pokemonService);

    @Named("idToTeam")
    default Team idToTeam(Integer id, @Context TeamService teamService) {
        return id == null ? null : teamService.getTeamById(id).orElse(null);
    }

    @Named("idToPokemon")
    default Pokemon idToPokemon(Integer id, @Context PokemonService pokemonService) {
        return id == null ? null : pokemonService.findPokemonById(id).orElse(null);
    }
}

