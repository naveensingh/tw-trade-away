package com.nyss.thoughtworks.tradeAway.service;

import com.nyss.thoughtworks.tradeAway.UserRepository;
import com.nyss.thoughtworks.tradeAway.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {


    @InjectMocks
    @Autowired
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Test
    public void shouldCallRepositoryMethod() {
        User user = mock(User.class);
        when(user.getId()).thenReturn(200L);
        userService.create(user);
        verify(userRepository, times(1)).save(user);
    }
}
