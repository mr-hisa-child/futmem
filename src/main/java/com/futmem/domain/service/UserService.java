package com.futmem.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futmem.domain.model.User;
import com.futmem.domain.repository.UserRepository;

@Service
@Transactional
public class UserService {
  @Autowired
  UserRepository userRepository;

  public Optional<User> find(int id) {
    return Optional.ofNullable(userRepository.findOne(id));
  }

  public User save(User user) {
    return userRepository.save(user);
  }
}
