package com.futmem.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futmem.domain.model.Attend;
import com.futmem.domain.repository.AttendRepository;

@Service
@Transactional
public class AttendService {
  @Autowired
  AttendRepository attendRepository;

  public Optional<Attend> find(int id) {
    return Optional.ofNullable(attendRepository.findOne(id));
  }

  public Optional<List<Attend>> findByMemberId(int memberId) {
    return attendRepository.findByMemberId(memberId);
  }

  public Attend save(Attend match) {
    return attendRepository.save(match);
  }
}
