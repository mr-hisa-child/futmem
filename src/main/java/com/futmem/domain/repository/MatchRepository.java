package com.futmem.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.futmem.domain.model.Match;

public interface MatchRepository extends JpaRepository<Match, Integer> {
  @Query(value = "select m from Match m where m.team.teamId = :teamId")
  public Optional<List<Match>> findByTeamId(@Param("teamId") int teamId);
}
