package com.rokomari.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rokomari.demo.dao.UserRepo;
import com.rokomari.demo.model.User;

@SpringBootTest
class DemoProjectApplicationTests {

	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void findUser() {
		List<User> userList = userRepo.findAll();
		System.out.println(userList.size());
		for (User user : userList) {
			System.out.println(user.toString());
		}
	}
	
	@Test
	void addUser() {
		try {
			User user = new User();
			user.setUserName("tanmoy069");
			user.setFirstName("Tanmoy");
			user.setLastName("Tushar");
			user.setAddress("Mymensingh, Dhaka");
			user.setAge(25);
			user.setEmail("pdt.tanmoy@gmail.com");
			user.setMaritalStatus("Single");
			user.setProfession("Student");
			user.setPhone(1672125148);
			userRepo.save(user);
			System.out.println("Successfully user added");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	void updateUser() {
		try {
			User user = userRepo.findUserByUserId(1);
			System.out.println(user.toString());
			user.setAge(26);
			userRepo.save(user);
			System.out.println("Successfully user Updated");
			User user1 = userRepo.findUserByUserId(1);
			System.out.println(user1.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
