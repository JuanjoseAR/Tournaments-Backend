package com.tournaments.tournaments.repositories;

import com.tournaments.tournaments.entities.TeamPokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamPokemonRepository extends JpaRepository<TeamPokemon, Integer> {
}
