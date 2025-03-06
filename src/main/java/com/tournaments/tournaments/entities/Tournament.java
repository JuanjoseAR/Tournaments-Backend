package com.tournaments.tournaments.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id
    @ColumnDefault("nextval('tournaments_tournamentid_seq')")
    @Column(name = "tournamentid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tournamentstateid", nullable = false)
    private TournamentState tournamentstateid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "eliminationformatid", nullable = false)
    private EliminationFormat eliminationformatid;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "maxparticipantquantity", nullable = false)
    private Integer maxparticipantquantity;

    @Column(name = "minparticipantquantity", nullable = false)
    private Integer minparticipantquantity;

    @Column(name = "startdate", nullable = false)
    private LocalDate startdate;

    @Column(name = "enddate", nullable = false)
    private LocalDate enddate;

}