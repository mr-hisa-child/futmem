package com.futmem.app.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.futmem.app.error.ApiException;
import com.futmem.app.response.TeamResponse;
import com.futmem.app.response.UserResponse;
import com.futmem.domain.model.Team;
import com.futmem.domain.model.User;
import com.futmem.domain.service.TeamService;
import com.futmem.domain.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {

  @Autowired
  UserService userService;

  @Autowired
  TeamService teamService;

  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  public UserResponse.Basic get(@PathVariable int id) {

    UserResponse.Basic response = new UserResponse.Basic();

    Optional<User> user = userService.find(id);
    if (!user.isPresent()) {
      throw new ApiException(HttpStatus.NOT_FOUND.value(), "user not found.");
    }
    BeanUtils.copyProperties(user.get(), response);
    return response;
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public UserResponse.Basic post(@Validated @RequestBody User request) {
    UserResponse.Basic response = new UserResponse.Basic();
    User user = userService.save(request);
    BeanUtils.copyProperties(user, response);
    return response;
  }

  @RequestMapping(value = "{id}/teams", method = RequestMethod.GET)
  public List<TeamResponse.Basic> getTeams(@PathVariable int id) {
    List<TeamResponse.Basic> responseList = new ArrayList<>();

    Optional<List<Team>> teamList = teamService.findByUserId(id);

    teamList.get().stream().forEach(team -> {
      TeamResponse.Basic response = new TeamResponse.Basic();
      BeanUtils.copyProperties(team, response);
      responseList.add(response);
    });

    return responseList;
  }
}
