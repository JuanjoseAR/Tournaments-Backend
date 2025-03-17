package com.tournaments.tournaments.repositories;

import com.tournaments.tournaments.entities.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
    @Query("SELECT t.minParticipantQuantity FROM Tournament t WHERE t.id = :tournamentId")
    Integer getMinParticipantQuantityById(@Param("tournamentId") Integer tournamentId);
}
