package com.futmem.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futmem.domain.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
