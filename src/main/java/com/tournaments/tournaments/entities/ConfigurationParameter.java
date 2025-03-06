package com.tournaments.tournaments.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "configurationparameters")
public class ConfigurationParameter {
    @Id
    @ColumnDefault("nextval('configurationparameters_configurationparameterid_seq')")
    @Column(name = "configurationparameterid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "datatype", nullable = false, length = 50)
    private String datatype;

    @Column(name = "description", length = 500)
    private String description;

    @ColumnDefault("false")
    @Column(name = "ismandatory", nullable = false)
    private Boolean ismandatory = false;

    @ColumnDefault("false")
    @Column(name = "isunique", nullable = false)
    private Boolean isunique = false;

}