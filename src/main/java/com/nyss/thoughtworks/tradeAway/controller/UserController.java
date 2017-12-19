package com.nyss.thoughtworks.tradeAway.controller;

import com.nyss.thoughtworks.tradeAway.models.User;
import com.nyss.thoughtworks.tradeAway.service.UserService;
import com.nyss.thoughtworks.tradeAway.utilities.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    InputValidator inputValidator;


    @PostMapping
    public ResponseEntity<Void> create(@RequestBody User user, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        if (isValidUser(user)) {
            userService.create(user);
            headers.setLocation(builder.path("/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } else {
            headers.add("Error Response", "User is not valid");
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    private boolean isValidUser(User user) {
        if (inputValidator.validateStringForAlphanumericCharacters(user.getName())
                && inputValidator.validateStringForEmail(user.getEmailId())
                && inputValidator.validateStringForNumbers(user.getMobile())
                && inputValidator.validateStringForAlphabetsOnly(user.getGender().toString()))
            return true;
        return false;

    }

}
