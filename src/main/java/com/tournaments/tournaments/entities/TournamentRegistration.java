package com.tournaments.tournaments.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "tournamentregistrations")
public class TournamentRegistration {
    @Id
    @ColumnDefault("nextval('tournamentregistrations_tournamentregistrationid_seq')")
    @Column(name = "tournamentregistrationid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tournamentid", nullable = false)
    private Tournament tournament;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trainerid", nullable = false)
    private Trainer trainer;
}