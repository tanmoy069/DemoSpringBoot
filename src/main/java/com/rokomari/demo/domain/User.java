package com.rokomari.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
//@Table(name="user_details", uniqueConstraints=@UniqueConstraint(columnNames={"username","email"}))
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
        super();
    }

    public User(int userId, String username, String firstName, String lastName, String address, String profession,
                String maritalStatus, int age, String email, int phone, String password) {
        super();
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.profession = profession;
        this.maritalStatus = maritalStatus;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName="
                + lastName + ", address=" + address + ", profession=" + profession + ", maritalStatus=" + maritalStatus
                + ", age=" + age + ", email=" + email + ", phone=" + phone + ", password=" + password + "]";
    }

}
