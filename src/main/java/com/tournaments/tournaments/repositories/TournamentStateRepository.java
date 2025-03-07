package com.tournaments.tournaments.repositories;

import com.tournaments.tournaments.entities.TournamentState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentStateRepository extends JpaRepository<TournamentState, Integer> {
}
