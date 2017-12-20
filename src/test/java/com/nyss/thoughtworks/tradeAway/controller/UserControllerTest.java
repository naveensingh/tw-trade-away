package com.nyss.thoughtworks.tradeAway.controller;

import com.nyss.thoughtworks.tradeAway.models.User;
import com.nyss.thoughtworks.tradeAway.service.UserService;
import com.nyss.thoughtworks.tradeAway.utilities.UserValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private UserValidator userValidator;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void shouldVerifyIfUserIsCreatedForValidInputData() {
        long dummyId = 200L;
        String expectedResponseBody = Long.toString(dummyId);
        User user = new User();
        user.setPassword("navin12#");
        when(userService.create(user)).thenReturn(dummyId);
        when(userValidator.validate(user)).thenReturn(new ArrayList<>());

        ResponseEntity<String> responseEntity = userController.create(user);

        verify(userValidator, times(1)).validate(user);
        verify(userService, times(1)).create(user);
        assertEquals(expectedResponseBody, responseEntity.getBody());
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }


    @Test
    public void shouldVerifyIfBadRequestIsCommunicatedInResponseForViolationOfConstraintsInInputData() {
        List<String> violations = new ArrayList<>();
        String firstViolation = "violation 1";
        String secondViolation = "violation 2";
        String thirdViolation = "violation 3";
        violations.add(firstViolation);
        violations.add(secondViolation);
        violations.add(thirdViolation);

        User user = new User();
        when(userValidator.validate(user)).thenReturn(violations);

        ResponseEntity<String> responseEntity = userController.create(user);

        verify(userValidator, times(1)).validate(user);
        verify(userService, times(0)).create(user);
        assertTrue(responseEntity.getBody().contains(firstViolation));
        assertTrue(responseEntity.getBody().contains(secondViolation));
        assertTrue(responseEntity.getBody().contains(thirdViolation));
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

}
