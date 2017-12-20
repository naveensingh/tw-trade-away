package com.nyss.thoughtworks.tradeAway.service;

import com.nyss.thoughtworks.tradeAway.models.User;

public interface UserService {
    Long create(User user);
    void truncateNonBuyerAttribute(User user);
    void truncateNonSellerAttribute(User user);
}
