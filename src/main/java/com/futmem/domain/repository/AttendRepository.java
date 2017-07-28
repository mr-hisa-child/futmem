package com.futmem.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.futmem.domain.model.Attend;

public interface AttendRepository extends JpaRepository<Attend, Integer> {
  @Query(value = "select a from Attend a where a.member.memberId = :memberId")
  public Optional<List<Attend>> findByMemberId(@Param("memberId") int memberId);
}
