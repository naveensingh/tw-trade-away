package com.nyss.thoughtworks.tradeAway.service;

import com.nyss.thoughtworks.tradeAway.repository.UserRepository;
import com.nyss.thoughtworks.tradeAway.models.User;
import org.junit.Assert;
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
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void verifyIfCreateMethodReturnsUserIdOfCreatedUser() {
        User user = mock(User.class);
        long expectedId = 200L;
        when(user.getId()).thenReturn(expectedId);
        when(userRepository.save(user)).thenReturn(user);

        long actualId = userService.create(user);

        verify(userRepository, times(1)).save(user);
        Assert.assertEquals(expectedId, actualId);
    }
}
