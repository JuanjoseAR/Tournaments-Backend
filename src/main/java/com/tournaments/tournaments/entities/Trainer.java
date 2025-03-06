package com.tournaments.tournaments.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "trainers")
public class Trainer {
    @Id
    @ColumnDefault("nextval('trainers_trainerid_seq')")
    @Column(name = "trainerid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teamid", nullable = false)
    private Team teamid;

    @Column(name = "name", nullable = false, length = 250)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sexid", nullable = false)
    private Sex sexid;

}