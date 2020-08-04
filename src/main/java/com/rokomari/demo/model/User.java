package com.rokomari.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String address;
	private String profession;
	private String maritalStatus;
	private int age;

}
