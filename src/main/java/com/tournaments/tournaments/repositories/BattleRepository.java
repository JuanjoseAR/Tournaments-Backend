package com.tournaments.tournaments.repositories;

import com.tournaments.tournaments.entities.Battle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BattleRepository extends JpaRepository<Battle, Integer> {
    boolean existsByPhaseId(Integer phaseId);
    List<Battle> findByPhaseId(Integer phaseId);
    Long countByPhaseId(Integer phaseId);

    @Query("SELECT COUNT(b) FROM Battle b WHERE b.phase.id = :phaseId AND b.winner.id IS NULL")
    long countByPhaseIdAndWinnerIsNull(@Param("phaseId") Integer phaseId);

    @Query("SELECT b FROM Battle b WHERE b.phase.id = :phaseId AND b.phase.tournament.id = :tournamentId")
    List<Battle> findByPhaseIdAndTournamentId(@Param("phaseId") Integer phaseId, @Param("tournamentId") Integer tournamentId);
}
