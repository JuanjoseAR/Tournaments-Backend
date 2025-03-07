package com.tournaments.tournaments.repositories;

import com.tournaments.tournaments.entities.TournamentConfigurationParameterValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentConfigurationParameterValueRepository extends JpaRepository<TournamentConfigurationParameterValue, Integer> {
}
