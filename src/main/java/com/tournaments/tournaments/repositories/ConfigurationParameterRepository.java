package com.tournaments.tournaments.repositories;

import com.tournaments.tournaments.entities.ConfigurationParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationParameterRepository extends JpaRepository<ConfigurationParameter, Integer> {
}
