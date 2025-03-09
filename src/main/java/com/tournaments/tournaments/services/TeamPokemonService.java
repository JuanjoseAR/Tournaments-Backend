package com.tournaments.tournaments.services;

import com.tournaments.tournaments.dto.TeamPokemonDTO;
import com.tournaments.tournaments.entities.TeamPokemon;

import java.util.List;
import java.util.Optional;

public interface TeamPokemonService {
    Optional<TeamPokemonDTO> getTeamPokemonById(Integer id);
    Optional<TeamPokemon> findTeamPokemonById(Integer id);
    List<TeamPokemonDTO> getAllTeamsPokemon();
    TeamPokemonDTO createTeamPokemon(TeamPokemonDTO teamPokemonDTO);
    Optional<TeamPokemonDTO> updateTeamPokemonById(Integer id, TeamPokemonDTO teamPokemonDTO);
    void deleteTeamPokemonById(Integer id);
}
