package com.futmem.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.futmem.domain.dto.LoginUser;
import com.futmem.domain.model.User;
import com.futmem.domain.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String mailAddress) throws UsernameNotFoundException {

    if (StringUtils.isEmpty(mailAddress)) {
      throw new UsernameNotFoundException("mailaddress is empty");
    }

    Optional<User> user = userRepository.findByMailaddress(mailAddress);

    // ユーザー情報を取得できなかった場合
    if (!user.isPresent()) {
      throw new UsernameNotFoundException("User not found for login id: " + mailAddress);
    }

    // System.out.println(new
    // BCryptPasswordEncoder().encode(user.getPassword()));

    // ユーザー情報が取得できたらSpring Securityで認証できる形で戻す
    return new LoginUser(user.get());
  }

  @Autowired
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

}
