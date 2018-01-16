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

import com.futmem.app.error.ApiException;
import com.futmem.app.response.UserResponse;
import com.futmem.domain.model.Match;
import com.futmem.domain.service.MatchService;
import com.futmem.domain.service.TeamService;

@RestController
@RequestMapping("api/matches")
public class MatchController {

    @Autowired
    MatchService matchService;

    @Autowired
    TeamService teamService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public UserResponse.Basic get(@PathVariable int id) {

        UserResponse.Basic response = new UserResponse.Basic();

        Optional<Match> match = matchService.find(id);
        if (!match.isPresent()) {
            throw new ApiException(HttpStatus.NOT_FOUND.value(), "user not found.");
        }
        BeanUtils.copyProperties(match.get(), response);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse.Basic post(@Validated @RequestBody Match request) {
        UserResponse.Basic response = new UserResponse.Basic();
        Match user = matchService.save(request);
        BeanUtils.copyProperties(user, response);
        return response;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public UserResponse.Basic put(@PathVariable int id, @Validated @RequestBody Match request) {
        UserResponse.Basic response = new UserResponse.Basic();
        Optional<Match> entity = matchService.find(id);
        if (!entity.isPresent()) {
            throw new ApiException(HttpStatus.NOT_FOUND.value(), "user not found.");
        }

        Match user = matchService.save(request);
        BeanUtils.copyProperties(user, response);
        return response;
    }
}
