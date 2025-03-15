package com.tournaments.tournaments.repositories;

import com.tournaments.tournaments.dto.PhaseDTO;
import com.tournaments.tournaments.entities.Phase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhaseRepository extends JpaRepository<Phase, Integer> {
    Phase findByTournamentId(Integer tournamentId);
}
