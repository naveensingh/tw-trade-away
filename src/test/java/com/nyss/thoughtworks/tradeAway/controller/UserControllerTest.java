package com.nyss.thoughtworks.tradeAway.controller;

import com.nyss.thoughtworks.tradeAway.models.User;
import com.nyss.thoughtworks.tradeAway.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    @Autowired
    UserController userController;

    @Mock
    UserService userService;


    @Test
    public void shouldVerifyIfUserServiceISCalled() {
        User user = mock(User.class);
        when(user.getId()).thenReturn(200L);
        userController.create(user, UriComponentsBuilder.newInstance());
        verify(userService, times(1)).create(user);
    }
}
