package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.TeamPokemon;
import com.tournaments.tournaments.entities.Trainer;

import java.util.List;
import java.util.Optional;

public interface TeamPokemonService {
    Optional<TeamPokemon> getTeamPokemonById(Integer id);
    List<TeamPokemon> getAllTeamsPokemon();
    TeamPokemon createTeamPokemon(TeamPokemon teamPokemon);
    Optional<TeamPokemon> updateTeamPokemonById(Integer id, TeamPokemon teamPokemon);
    void deleteTeamPokemonById(Integer id);
}
