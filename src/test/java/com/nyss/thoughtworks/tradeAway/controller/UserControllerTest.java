package com.nyss.thoughtworks.tradeAway.controller;

import com.nyss.thoughtworks.tradeAway.models.Gender;
import com.nyss.thoughtworks.tradeAway.models.User;
import com.nyss.thoughtworks.tradeAway.service.UserService;
import com.nyss.thoughtworks.tradeAway.utilities.InputValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    @Autowired
    UserController userController;

    @Mock
    UserService userService;

    @Mock
    InputValidator inputValidator;


    @Test
    public void shouldVerifyIfUserServiceISCalled() throws BadPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        User user = mock(User.class);
        when(user.getId()).thenReturn(200L);
        when(user.getGender()).thenReturn(Gender.MALE);
        when(inputValidator.validateStringForAlphanumericCharacters(any())).thenReturn(true);
        when(inputValidator.validateStringForAlphabetsOnly(any())).thenReturn(true);
        when(inputValidator.validateStringForEmail(any())).thenReturn(true);
        when(inputValidator.validateStringForNumbers(any())).thenReturn(true);
        userController.create(user, UriComponentsBuilder.newInstance());
        verify(userService, times(1)).create(user);
    }

    @Test
    public void shouldVerifyIfUserDetailsAreValidatedBeforeBeingCreated() throws BadPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        User user = new User();
        user.setName("John");
        user.setEmailId("jo$$4hn@doe.com");
        user.setUsername("johndoe");
        user.setPassword("johndoe");
        user.setMobile("0123456789");
        user.setAddress("A-707, India");
        user.setGender(Gender.MALE);
        Date date = new Date("03/12/1992");
        user.setDob(date);
        userController.create(user, UriComponentsBuilder.newInstance());
        verify(userService, times(0)).create(user);
    }

}
