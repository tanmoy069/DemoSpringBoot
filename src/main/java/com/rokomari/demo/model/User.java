package com.rokomari.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
//@Table(name="user_details", uniqueConstraints=@UniqueConstraint(columnNames={"user_name","email"}))
public class User {
	
	@Id
    @GeneratedValue
	private int userId;
	
//	@Column(name="user_name", length = 100)
	private String username;
	
	private String firstName;

	private String lastName;

	private String address;

	private String profession;

	private String maritalStatus;

	private int age;

//	@Column(name="email", length = 100)
	private String email;

	private int phone;

	private String password;
}
