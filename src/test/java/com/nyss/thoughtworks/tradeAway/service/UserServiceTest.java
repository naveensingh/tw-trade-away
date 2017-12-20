package com.nyss.thoughtworks.tradeAway.service;

import com.nyss.thoughtworks.tradeAway.models.User;
import com.nyss.thoughtworks.tradeAway.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.TestComponent;

import java.util.Date;

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

    @Test
    public void verifyIfNonBuyerAttributesAreTruncatedBeforeSavingBuyer()
    {
        User user = new User();
        user.setUserType("BUYER");
        user.setPanNumber("ABCD");
        user.setExperience(5);
        when(userRepository.save(user)).thenReturn(user);

        userService.create(user);


        Assert.assertEquals(null, user.getPanNumber());
        Assert.assertEquals(0, user.getExperience());
        verify(userRepository, times(1)).save(user);

    }

    @Test
    public void verifyIfNonSellerAttributesAreTruncatedBeforeSavingSeller()
    {
        User user = new User();
        user.setUserType("SELLER");
        user.setGender("MALE");
        user.setDob(new Date());
        when(userRepository.save(user)).thenReturn(user);

        userService.create(user);


        Assert.assertEquals(null, user.getGender());
        Assert.assertEquals(null, user.getDob());
        verify(userRepository, times(1)).save(user);

    }
}
