package com.futmem.app.controler;

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

import com.futmem.app.response.TeamResponse;
import com.futmem.domain.model.Team;
import com.futmem.domain.service.TeamService;

@RestController
@RequestMapping("api/teams")
public class TeamController {
  @Autowired
  TeamService teamService;

  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  public TeamResponse.Basic get(@PathVariable int id) {
    TeamResponse.Basic response = new TeamResponse.Basic();

    Optional<Team> team = teamService.find(id);

    BeanUtils.copyProperties(team, response);

    return response;
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public TeamResponse.Basic post(@Validated @RequestBody Team request) {
    TeamResponse.Basic response = new TeamResponse.Basic();
    Team team = teamService.save(request);
    BeanUtils.copyProperties(team, response);
    return response;
  }
}
