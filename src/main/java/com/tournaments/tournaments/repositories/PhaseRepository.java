package com.tournaments.tournaments.repositories;

import com.tournaments.tournaments.entities.Phase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhaseRepository extends JpaRepository<Phase, Integer> {
    List<Phase> findByTournamentIdOrderByConsecutiveNumberWithinTournament(Integer tournamentId);
    Phase findByTournamentIdAndConsecutiveNumberWithinTournament(Integer tournamentId, Integer consecutiveNumber);
}