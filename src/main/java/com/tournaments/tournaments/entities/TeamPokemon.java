package com.tournaments.tournaments.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "teampokemons")
public class TeamPokemon {
    @Id
    @ColumnDefault("nextval('teampokemons_teampokemonid_seq')")
    @Column(name = "teampokemonid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teamid", nullable = false)
    private Team teamid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pokemonid", nullable = false)
    private Pokemon pokemonid;

}