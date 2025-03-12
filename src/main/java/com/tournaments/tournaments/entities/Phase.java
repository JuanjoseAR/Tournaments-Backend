package com.tournaments.tournaments.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "phases")
public class Phase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phaseid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tournamentid", nullable = false)
    private Tournament tournament;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "eliminationformatid", nullable = false)
    private EliminationFormat eliminationFormat;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "consecutiveNumberWithinTournament", nullable = false)
    private Integer consecutiveNumberWithinTournament;

    @Column(name = "startdate", nullable = false)
    private LocalDate startDate;

    @Column(name = "enddate", nullable = false)
    private LocalDate endDate;
}