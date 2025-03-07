package com.tournaments.tournaments.repositories;

import com.tournaments.tournaments.entities.PokemonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonTypeRepository extends JpaRepository<PokemonType, Integer> {
}
