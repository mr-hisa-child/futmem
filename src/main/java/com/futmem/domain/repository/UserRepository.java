package com.futmem.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futmem.domain.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  public Optional<User> findByMailaddress(String mailaddress);
}
