package com.nyss.thoughtworks.tradeAway.controller;

import com.nyss.thoughtworks.tradeAway.models.User;
import com.nyss.thoughtworks.tradeAway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    public ResponseEntity<Void> create(@RequestBody User user, UriComponentsBuilder builder) {
        userService.create(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
