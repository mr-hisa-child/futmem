package com.futmem.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.futmem.domain.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
  @Query(value = "select * from m_team mt join t_user_team tut on tut.team_id = mt.team_id where tut.user_id = :userId", nativeQuery = true)
  public Optional<List<Team>> findByUserId(@Param("userId") int userId);
}
