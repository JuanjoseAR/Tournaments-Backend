package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.TeamPokemonDTO;

import java.util.List;
import java.util.Optional;

public interface TeamPokemonService {
    Optional<TeamPokemonDTO> getTeamPokemonById(Integer id);
    List<TeamPokemonDTO> getAllTeamsPokemon();
    TeamPokemonDTO createTeamPokemon(TeamPokemonDTO teamPokemonDTO);
    Optional<TeamPokemonDTO> updateTeamPokemonById(Integer id, TeamPokemonDTO teamPokemonDTO);
    void deleteTeamPokemonById(Integer id);
}
