package com.nyss.thoughtworks.tradeAway.service;

import com.nyss.thoughtworks.tradeAway.models.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User create(User user);
}
