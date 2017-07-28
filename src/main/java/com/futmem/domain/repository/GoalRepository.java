package com.futmem.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.futmem.domain.model.Goal;
import com.futmem.domain.model.GoalPK;

public interface GoalRepository extends JpaRepository<Goal, GoalPK> {
  @Query(value = "select g from Goal g where g.match.matchId = :matchId")
  public Optional<List<Goal>> findByMatchId(@Param("matchId") int matchId);

  @Query(value = "select g from Goal g where g.member.memberId = :memberId")
  public Optional<List<Goal>> findByMemberId(@Param("memberId") int memberId);
}
