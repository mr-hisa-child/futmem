package com.futmem.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.futmem.domain.model.Assist;
import com.futmem.domain.model.AssistPK;

public interface AssistRepository extends JpaRepository<Assist, AssistPK> {
  @Query(value = "select g from Assist g where g.match.matchId = :matchId")
  public Optional<List<Assist>> findByMatchId(@Param("matchId") int matchId);

  @Query(value = "select g from Assist g where g.member.memberId = :memberId")
  public Optional<List<Assist>> findByMemberId(@Param("memberId") int memberId);
}
