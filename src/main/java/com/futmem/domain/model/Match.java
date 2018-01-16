package com.futmem.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the t_match database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "t_match")
public class Match implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Integer matchId;

    @Column(name = "enemy_team_name")
    private String enemyTeamName;

    @Column(name = "goals_against")
    private Integer goalsAgainst;

    @Temporal(TemporalType.DATE)
    @Column(name = "match_date")
    private Date matchDate;

    // bi-directional many-to-one association to Goal
    @OneToMany(mappedBy = "match")
    private List<Goal> goalList;

    // bi-directional many-to-one association to Team
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}