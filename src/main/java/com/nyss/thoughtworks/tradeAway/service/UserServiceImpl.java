package com.nyss.thoughtworks.tradeAway.service;

import com.nyss.thoughtworks.tradeAway.repository.UserRepository;
import com.nyss.thoughtworks.tradeAway.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Long create(User user) {
        return userRepository.save(user).getId();
    }
}
