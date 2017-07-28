package com.futmem.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futmem.domain.model.Match;
import com.futmem.domain.repository.MatchRepository;

@Service
@Transactional
public class MatchService {
  @Autowired
  MatchRepository matchRepository;

  public Optional<Match> find(int id) {
    return Optional.ofNullable(matchRepository.findOne(id));
  }

  public Optional<List<Match>> findByTeamId(int teamId) {
    return matchRepository.findByTeamId(teamId);
  }

  public Match save(Match match) {
    return matchRepository.save(match);
  }
}
