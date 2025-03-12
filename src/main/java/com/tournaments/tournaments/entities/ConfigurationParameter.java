package com.tournaments.tournaments.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "configurationparameters")
public class ConfigurationParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "configurationparameterid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "dataType", nullable = false, length = 50)
    private String dataType;

    @Column(name = "description", length = 500)
    private String description;

    @ColumnDefault("false")
    @Column(name = "ismandatory", nullable = false)
    private Boolean isMandatory = false;

    @ColumnDefault("false")
    @Column(name = "isunique", nullable = false)
    private Boolean isUnique = false;
}