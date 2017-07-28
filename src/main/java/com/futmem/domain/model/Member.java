package com.futmem.domain.model;

import java.io.Serializable;
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

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the m_member database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "m_member")
public class Member implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Integer memberId;

  @Column(name = "member_name")
  private String memberName;

  private Integer no;

  // bi-directional many-to-one association to Team
  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;

  // bi-directional many-to-one association to Assist
  @OneToMany(mappedBy = "member")
  private List<Assist> assistList;

  // bi-directional many-to-one association to Attend
  @OneToMany(mappedBy = "member")
  private List<Attend> attendList;

  // bi-directional many-to-one association to Goal
  @OneToMany(mappedBy = "member")
  private List<Goal> goalList;
}