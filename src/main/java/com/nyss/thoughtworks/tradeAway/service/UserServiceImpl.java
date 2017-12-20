package com.nyss.thoughtworks.tradeAway.service;

import com.nyss.thoughtworks.tradeAway.models.User;
import com.nyss.thoughtworks.tradeAway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long create(User user) {
        truncateNonBuyerAttribute(user);
        truncateNonSellerAttribute(user);
        return userRepository.save(user).getId();
    }

    @Override
    public void truncateNonBuyerAttribute(User user){
        if("BUYER".equals(user.getUserType())) {
            user.setPanNumber(null);
            user.setExperience(0);
        }
    }

    @Override
    public void truncateNonSellerAttribute(User user) {
        if("SELLER".equals(user.getUserType())) {
            user.setGender(null);
            user.setDob(null);
        }
    }
}
