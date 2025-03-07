package com.tournaments.tournaments.repositories;

import com.tournaments.tournaments.entities.Phase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhaseRepository extends JpaRepository<Phase, Integer> {
}
