package com.nyss.thoughtworks.tradeAway.controller;

import com.nyss.thoughtworks.tradeAway.models.User;
import com.nyss.thoughtworks.tradeAway.service.UserService;
import com.nyss.thoughtworks.tradeAway.utilities.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody User user) {
        List<String> errors = userValidator.validate(user);
        if (errors.isEmpty()) {
            UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
            user.encryptPassword();
            HttpHeaders headers = new HttpHeaders();
            long id = userService.create(user);
            headers.setLocation(builder.path("/{id}").buildAndExpand(id).toUri());
            return new ResponseEntity<>(Long.toString(id), headers, HttpStatus.CREATED);
        }
        String errorsAsString = String.join(", ", errors);
        return new ResponseEntity<>(errorsAsString, HttpStatus.BAD_REQUEST);
    }

}
