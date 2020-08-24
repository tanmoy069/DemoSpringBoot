package com.rokomari.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rokomari.demo.repository.UserRepository;
import com.rokomari.demo.domain.User;

@SpringBootTest
class DemoProjectApplicationTests {

	@Autowired
	private UserRepository userRepo;
	
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
			user.setUsername("user10");
			user.setFirstName("Tanmoy");
			user.setLastName("Tushar");
			user.setAddress("Mymensingh, Dhaka");
			user.setAge(25);
			user.setEmail("user10@gmail.com");
			user.setMaritalStatus("Single");
			user.setProfession("Student");
			user.setPhone(1672125148);
			user.setPassword("admin1234");
			userRepo.save(user);
			System.out.println("Successfully user added");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void updateUser() {
		try {
			BCryptPasswordEncoder bc = new BCryptPasswordEncoder(12);
			User user = userRepo.findUserByUserId(3);
			System.out.println(user.toString());
//			user.setAge(26);
			user.setUsername("tanmoy069");
			user.setPassword(bc.encode("admin1234"));
			userRepo.save(user);
			System.out.println("Successfully user Updated");
			User user1 = userRepo.findUserByUserId(1);
			System.out.println(user1.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}

}
