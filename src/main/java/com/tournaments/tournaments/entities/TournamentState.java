package com.tournaments.tournaments.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "tournamentstates")
public class TournamentState {
    @Id
    @ColumnDefault("nextval('tournamentstates_tournamentstateid_seq')")
    @Column(name = "tournamentstateid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

}