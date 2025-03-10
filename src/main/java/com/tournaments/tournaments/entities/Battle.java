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
    @JoinColumn(name = "firstparticipantid", nullable = false)
    private Trainer firsParticipant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "secondparticipantid", nullable = false)
    private Trainer secondParticipant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "winnerid", nullable = false)
    private Trainer winner;

    @Column(name = "battleDuration", nullable = false)
    private LocalTime battleDuration;
}