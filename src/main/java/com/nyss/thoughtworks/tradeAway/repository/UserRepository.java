package com.nyss.thoughtworks.tradeAway.repository;

import com.nyss.thoughtworks.tradeAway.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
