package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.Team;
import com.tournaments.tournaments.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImp implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImp(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Optional<Team> getTeamById(String id) {
        return teamRepository.findById(id);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Optional<Team> updateTeamById(String id, Team team) { //This method won't be use either.
        return teamRepository.findById(id).map(
                teamInBD->{
                    teamInBD.setId(team.getId());

                    return teamRepository.save(teamInBD);
                }
        );
    }

    @Override
    public void deleteTeamById(String id) {
        teamRepository.deleteById(id);
    }
}
