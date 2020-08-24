package com.rokomari.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rokomari.demo.domain.User;
import com.rokomari.demo.repository.UserRepository;

@Service
public class MainService {

	@Autowired
	private UserRepository userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public Page<User> findAllByPage(Pageable pageable) {
		return userRepo.findAll(pageable);
	}

	public User findUserByUserId(int id) {
		return userRepo.findUserByUserId(id);
	}

	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	public void updateUser(User user) {
		setUpdateUser(user);
	}

	private void setUpdateUser(User user) {
		User currUser = findUserByUserId(user.getUserId());
		currUser.setFirstName(user.getFirstName());
		currUser.setLastName(user.getLastName());
		currUser.setAddress(user.getAddress());
		currUser.setAge(user.getAge());
		currUser.setEmail(user.getEmail());
		currUser.setMaritalStatus(user.getMaritalStatus());
		currUser.setPhone(user.getPhone());
		currUser.setProfession(user.getProfession());
		userRepo.save(currUser);
	}

	public List<Integer> getPageList(int totalPage) {
		return IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
	}

}
