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
        User inputUser = new User();
        long expectedId = 200L;
        User outputUser = new User();
        outputUser.setId(expectedId);
        when(userRepository.save(inputUser)).thenReturn(outputUser);

        long actualId = userService.create(inputUser);

        verify(userRepository, times(1)).save(inputUser);
        Assert.assertEquals(expectedId, actualId);
    }
}
