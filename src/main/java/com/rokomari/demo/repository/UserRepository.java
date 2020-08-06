package com.rokomari.demo.repository;

import com.rokomari.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUserId(int id);

    User findByUsername(String username);

}
