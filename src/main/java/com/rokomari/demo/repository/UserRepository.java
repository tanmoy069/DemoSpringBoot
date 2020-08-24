package com.rokomari.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rokomari.demo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByUserId(int id);

	User findByUsername(String username);

	Page<User> findAll(Pageable pageable);

}
