package com.nyss.thoughtworks.tradeAway.controller;

import com.nyss.thoughtworks.tradeAway.models.Gender;
import com.nyss.thoughtworks.tradeAway.models.User;
import com.nyss.thoughtworks.tradeAway.models.UserErrorResponse;
import com.nyss.thoughtworks.tradeAway.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void shouldVerifyIfUserIsCreatedForValidInputData() {
        when(userService.create(any())).thenReturn(200L);
        User user = new User();
        user.setName("Navin"); user.setDob(new Date());
        user.setPassword("navin12#"); user.setAddress("Hyd"); user.setMobile("1234567899"); user.setGender(Gender.MALE); user.setEmailId("navin@bb.com");
        ResponseEntity<Long> responseEntity = userController.create(user);

        verify(userService,times(1)).create(user);
        assertEquals(200, responseEntity.getBody().intValue());
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void shouldVerifyIfErrorIsReturnedForInvalidInputData()  {
        Set<ConstraintViolation<User>> setOfViolations = new HashSet<>();
        ConstraintViolation<User> violation = mock(ConstraintViolation.class);
        when(violation.getMessageTemplate()).thenReturn("Email format not recognized");
        setOfViolations.add(violation);
        ConstraintViolationException exception = new ConstraintViolationException(setOfViolations);

        UserErrorResponse response = userController.handleException(exception);

        verify(violation, times(1)).getMessageTemplate();
        assertEquals("Email format not recognized", response.getMessage());
    }

    @Test
    public void shouldVerifyIfErrorIsReturnedForMultipleErrorsInData()  {
        Set<ConstraintViolation<User>> setOfViolations = new HashSet<>();
        ConstraintViolation<User> firstViolation = mock(ConstraintViolation.class);
        when(firstViolation.getMessageTemplate()).thenReturn("Email format not recognized");
        setOfViolations.add(firstViolation);

        ConstraintViolation<User> secondViolation = mock(ConstraintViolation.class);
        when(secondViolation.getMessageTemplate()).thenReturn("Mobile number should not be greater than 10 characters");
        setOfViolations.add(secondViolation);

        ConstraintViolationException exception = new ConstraintViolationException(setOfViolations);

        UserErrorResponse response = userController.handleException(exception);

        verify(firstViolation, times(1)).getMessageTemplate();
        verify(secondViolation, times(1)).getMessageTemplate();
        assertEquals("Email format not recognized, Mobile number should not be greater than 10 characters", response.getMessage());
    }

}
