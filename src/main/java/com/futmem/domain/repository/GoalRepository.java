package com.futmem.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.futmem.domain.model.Goal;

public interface GoalRepository extends JpaRepository<Goal, Integer> {
    @Query(value = "select g from Goal g where g.match.matchId = :matchId")
    public Optional<List<Goal>> findByMatchId(@Param("matchId") int matchId);

    @Query(value = "select g.goalMemberId,count(g.goalId) from Goal g where g.match.teamId = :teamId and g.match.matchDate like :summary group by g.goalMemberId")
    public Optional<List<Goal>> findGoalRanking(@Param("teamId") int teamId, @Param("summary") String summary);
}
