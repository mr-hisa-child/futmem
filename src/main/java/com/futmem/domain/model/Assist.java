package com.futmem.domain.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the t_assist database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "t_assist")
public class Assist implements Serializable {
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private AssistPK id;

  private Integer score;

  // bi-directional many-to-one association to Member
  @ManyToOne
  @JoinColumn(name = "member_id", insertable = false, updatable = false)
  private Member member;

  // bi-directional many-to-one association to TMatch
  @ManyToOne
  @JoinColumn(name = "score_id", insertable = false, updatable = false)
  private Match match;

  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;
}