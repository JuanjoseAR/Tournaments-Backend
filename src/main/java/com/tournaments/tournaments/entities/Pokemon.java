package com.tournaments.tournaments.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "pokemons")
public class Pokemon {
    @Id
    @ColumnDefault("nextval('pokemons_pokemonid_seq')")
    @Column(name = "pokemonid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 250)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pokemontypeid", nullable = false)
    private PokemonType pokemonType;

    @Column(name = "level", nullable = false)
    private Integer level;

}