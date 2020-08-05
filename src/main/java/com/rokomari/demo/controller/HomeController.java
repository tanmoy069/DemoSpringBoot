package com.rokomari.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rokomari.demo.dao.UserRepo;
import com.rokomari.demo.model.User;

@Controller
public class HomeController {

	@Autowired
	private UserRepo userRepo;
	
    @RequestMapping("/")
    public String home(){
        return "UserList";
    }

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @GetMapping("/userlist")
    public String getUserList(Model model){
    	model.addAttribute("userObj", userRepo.findAll());
        return "UserList";
    }
    
    @GetMapping("/userview")
    public String getUser(Model model, @RequestParam(value="id") int userId){
    	model.addAttribute("userDetails", userRepo.findUserByUserId(userId));
        return "UserView";
    }
    
    @GetMapping("/userupdate")
    public String userUpdate(Model model, @RequestParam(value="id") int userId){
    	model.addAttribute("userDetails", userRepo.findUserByUserId(userId));
        return "UserUpdate";
    }
    
    @PostMapping("/userupdate")
    public String updateUser(@ModelAttribute(name="updateUserForm") User user, Model model, @RequestParam(value="id") int userId){
    	model.addAttribute("userDetails", userRepo.findUserByUserId(userId));
    	try {
        	User currUser = userRepo.findUserByUserId(userId);
        	currUser.setFirstName(user.getFirstName());
        	currUser.setLastName(user.getLastName());
        	currUser.setAddress(user.getAddress());
        	currUser.setAge(user.getAge());
        	currUser.setEmail(user.getEmail());
        	currUser.setMaritalStatus(user.getMaritalStatus());
        	currUser.setPhone(user.getPhone());
        	currUser.setProfession(user.getProfession());
        	userRepo.save(currUser);
        	model.addAttribute("validCredentials", true);
		} catch (Exception e) {
			model.addAttribute("invalidCredentials", true);
		}
        return "UserUpdate";
    }
    
}
