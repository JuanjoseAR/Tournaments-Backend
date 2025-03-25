package com.tournaments.tournaments.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @Column(name = "teamid", nullable = false)
    private Integer id;
}