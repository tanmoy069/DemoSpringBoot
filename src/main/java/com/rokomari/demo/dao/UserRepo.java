package com.rokomari.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rokomari.demo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findUserByUserId(int id);

}
