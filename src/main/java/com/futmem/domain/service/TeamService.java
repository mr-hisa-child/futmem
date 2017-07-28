package com.futmem.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futmem.domain.model.Team;
import com.futmem.domain.model.User;
import com.futmem.domain.repository.TeamRepository;
import com.futmem.domain.repository.UserRepository;

@Service
@Transactional
public class TeamService {
  @Autowired
  TeamRepository teamRepository;

  @Autowired
  UserRepository userRepository;

  public Optional<Team> find(int id) {
    return Optional.ofNullable(teamRepository.findOne(id));
  }

  public Optional<List<Team>> findByUserId(int userId) {
    return teamRepository.findByUserId(userId);
  }

  public Team save(Team input) {
    return teamRepository.save(input);
  }

  public Team save(Team teamEntry, User userEntry) {

    Team team = teamRepository.save(teamEntry);

    userEntry.getTeamList().add(team);

    userRepository.save(userEntry);

    return team;
  }
}
