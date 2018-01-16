package com.futmem.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futmem.domain.model.Goal;
import com.futmem.domain.repository.GoalRepository;

@Service
@Transactional
public class GoalService {
    @Autowired
    GoalRepository goalRepository;

    public Optional<Goal> find(int goalId) {
        return Optional.ofNullable(goalRepository.findOne(goalId));
    }

    public Optional<List<Goal>> findByMatchId(int matchId) {
        return goalRepository.findByMatchId(matchId);
    }

    public Goal save(Goal match) {
        return goalRepository.save(match);
    }
}
