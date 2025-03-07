package com.tournaments.tournaments.repositories;

import com.tournaments.tournaments.entities.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexRepository extends JpaRepository<Sex, Integer> {
}
