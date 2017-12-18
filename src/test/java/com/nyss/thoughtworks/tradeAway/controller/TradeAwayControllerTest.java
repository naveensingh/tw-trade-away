package com.nyss.thoughtworks.tradeAway.controller;

import com.nyss.thoughtworks.tradeAway.models.User;
import com.nyss.thoughtworks.tradeAway.service.UserService;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class TradeAwayControllerTest {


    @Test
    public void shouldVerifyIfUserServiceISCalled() {
        UserController userController = mock(UserController.class);
        User user = mock(User.class);
        userController.create(user);
//        verify(userService, times(1)).create(user);

    }
}
