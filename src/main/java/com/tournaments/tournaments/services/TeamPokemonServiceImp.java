package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.TeamPokemon;
import com.tournaments.tournaments.repositories.TeamPokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamPokemonServiceImp implements TeamPokemonService {

    private TeamPokemonRepository teamPokemonRepository;

    public TeamPokemonServiceImp(TeamPokemonRepository teamPokemonRepository) {
        this.teamPokemonRepository = teamPokemonRepository;
    }

    @Override
    public Optional<TeamPokemon> getTeamPokemonById(Integer id) {
        return teamPokemonRepository.findById(id);
    }

    @Override
    public List<TeamPokemon> getAllTeamsPokemon() {
        return teamPokemonRepository.findAll();
    }

    @Override
    public TeamPokemon createTeamPokemon(TeamPokemon teamPokemon) {
        return teamPokemonRepository.save(teamPokemon);
    }

    @Override
    public Optional<TeamPokemon> updateTeamPokemonById(Integer id, TeamPokemon teamPokemon) {
        return teamPokemonRepository.findById(id).map(
                teamPokeInBD->{
                    teamPokeInBD.setTeamid(teamPokemon.getTeamid());
                    teamPokeInBD.setPokemonid(teamPokemon.getPokemonid());

                    return teamPokemonRepository.save(teamPokemon);
                }
        );
    }

    @Override
    public void deleteTeamPokemonById(Integer id) {
        teamPokemonRepository.deleteById(id);
    }
}
