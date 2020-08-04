package com.rokomari.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_details", uniqueConstraints=@UniqueConstraint(columnNames={"user_name","email"}))
public class User {
	
	@Id
    @GeneratedValue
    @Column(name="user_id")
	private int userId;
	
	@Column(name="user_name", length = 100)
	private String userName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="profession")
	private String profession;
	
	@Column(name="marital_status")
	private String maritalStatus;
	
	@Column(name="age")
	private int age;
	
	@Column(name="email", length = 100)
	private String email;
	
	@Column(name="phone")
	private int phone;

}
