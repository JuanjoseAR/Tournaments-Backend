package com.tournaments.tournaments.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "tournamentconfigurationparametervalues")
public class TournamentConfigurationParameterValue {
    @Id
    @ColumnDefault("nextval('tournamentconfigurationparame_tournamentconfigurationparame_seq')")
    @Column(name = "tournamentconfigurationparametervalueid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tournamentid", nullable = false)
    private TournamentState tournamentid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "configurationparameterid", nullable = false)
    private ConfigurationParameter configurationparameterid;

    @Column(name = "value", nullable = false, length = 1000)
    private String value;

}