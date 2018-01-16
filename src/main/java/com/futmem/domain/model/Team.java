package com.futmem.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the m_team database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "m_team")
public class Team implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "team_name")
    private String teamName;

    // bi-directional many-to-one association to Member
    @OneToMany(mappedBy = "team")
    private List<Member> memberList;

    // bi-directional many-to-one association to TMatch
    @OneToMany(mappedBy = "team")
    private List<Match> matchList;
}