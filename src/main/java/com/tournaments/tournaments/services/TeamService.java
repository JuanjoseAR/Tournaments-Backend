package com.tournaments.tournaments.services;

import com.tournaments.tournaments.entities.Team;
import com.tournaments.tournaments.entities.Trainer;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    Optional<Team> getTeamById(Integer id);
    List<Team> getAllTeams();
    Team createTeam(Team team);
    Optional<Team> updateTeamById(Integer id, Team team);
    void deleteTeamById(Integer id);
}
