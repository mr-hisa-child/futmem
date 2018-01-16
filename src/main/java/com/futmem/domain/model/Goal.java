package com.futmem.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the t_goal database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "t_goal")
public class Goal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Integer goalId;

    @ManyToOne
    @JoinColumn(name = "goal_member_id", insertable = false, updatable = false)
    private Member goalMember;

    @ManyToOne
    @JoinColumn(name = "assist_member_id", insertable = false, updatable = false)
    private Member assistMember;

    @ManyToOne
    @JoinColumn(name = "score_id", insertable = false, updatable = false)
    private Match match;
}