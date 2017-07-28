package com.futmem.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futmem.domain.model.Assist;
import com.futmem.domain.model.AssistPK;
import com.futmem.domain.repository.AssistRepository;

@Service
@Transactional
public class AssistService {
  @Autowired
  AssistRepository assistRepository;

  public Optional<Assist> find(int matchId, int memberId) {
    return Optional.ofNullable(assistRepository.findOne(new AssistPK(matchId, memberId)));
  }

  public Optional<List<Assist>> findByMemberId(int memberId) {
    return assistRepository.findByMemberId(memberId);
  }

  public Optional<List<Assist>> findByMatchId(int matchId) {
    return assistRepository.findByMatchId(matchId);
  }

  public Assist save(Assist match) {
    return assistRepository.save(match);
  }
}
