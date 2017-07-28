package com.futmem.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the t_attend database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "t_attend")
public class Attend implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "attend_id")
  private Integer attendId;

  @Temporal(TemporalType.DATE)
  @Column(name = "attend_date")
  private Date attendDate;

  // bi-directional many-to-one association to Member
  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;

  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;
}