package com.tournaments.tournaments.repositories;

import com.tournaments.tournaments.entities.TournamentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRegistrationRepository extends JpaRepository<TournamentRegistration, Integer> {
    boolean existsByTournamentIdAndTrainerId(Integer tournamentId, Integer trainerId);
    List<TournamentRegistration> findByTournamentId(Integer tournamentId);
    @Query("SELECT tr.trainer.id FROM TournamentRegistration tr WHERE tr.tournament.id = :tournamentId")
    List<Integer> findTrainerIdsByTournamentId(@Param("tournamentId") Integer tournamentId);
}
