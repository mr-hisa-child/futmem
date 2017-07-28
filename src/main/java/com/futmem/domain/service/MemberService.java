package com.futmem.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futmem.domain.model.Member;
import com.futmem.domain.repository.MemberRepository;

@Service
@Transactional
public class MemberService {
  @Autowired
  MemberRepository memberRepository;

  public Optional<Member> find(int id) {
    return Optional.ofNullable(memberRepository.findOne(id));
  }

  public Member save(Member member) {
    return memberRepository.save(member);
  }
}
