package com.tournaments.tournaments.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "battles")
public class Battle {
    @Id
    @ColumnDefault("nextval('battles_battleid_seq')")
    @Column(name = "battleid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "phaseid", nullable = false)
    private Phase phase;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "winnerid", nullable = false)
    private Trainer winner;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "loserid", nullable = false)
    private Trainer loser;

    @Column(name = "battleDuration", nullable = false)
    private LocalTime battleDuration;
}