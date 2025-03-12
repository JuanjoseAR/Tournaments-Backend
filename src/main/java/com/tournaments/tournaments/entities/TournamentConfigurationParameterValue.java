package com.tournaments.tournaments.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tournamentconfigurationparametervalues")
public class TournamentConfigurationParameterValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournamentconfigurationparametervalueid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tournamentid", nullable = false)
    private TournamentState tournament;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "configurationparameterid", nullable = false)
    private ConfigurationParameter configurationParameter;

    @Column(name = "value", nullable = false, length = 1000)
    private String value;
}