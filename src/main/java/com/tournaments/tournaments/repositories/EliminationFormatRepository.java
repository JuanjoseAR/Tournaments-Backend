package com.tournaments.tournaments.repositories;

import com.tournaments.tournaments.entities.EliminationFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EliminationFormatRepository extends JpaRepository<EliminationFormat, Integer> {
}
