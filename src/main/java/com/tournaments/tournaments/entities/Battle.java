package com.tournaments.tournaments.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@Entity
@Table(name = "battles")
public class Battle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "battleid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "phaseid", nullable = false)
    private Phase phase;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "firstparticipantid", nullable = false)
    private Trainer firstParticipant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "secondparticipantid", nullable = false)
    private Trainer secondParticipant;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "winnerid", nullable = true)
    private Trainer winner;

    @Column(name = "battleduration", nullable = true)
    private Time battleDuration;
}