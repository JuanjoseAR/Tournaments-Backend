package com.tournaments.tournaments.repositories;

import com.tournaments.tournaments.entities.Battle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleRepository extends JpaRepository<Battle, Integer> {
    boolean existsByPhaseIdAndWinnerIsNull(Integer phaseId);
}
