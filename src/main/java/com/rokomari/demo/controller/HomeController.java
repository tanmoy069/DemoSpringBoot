package com.rokomari.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rokomari.demo.dao.UserRepo;

@Controller
public class HomeController {

	@Autowired
	private UserRepo userRepo;
	
    @RequestMapping("/")
    public String home(){
        return "index";
    }
    
    @GetMapping("/userlist")
    public String getUserList(Model model){
    	model.addAttribute("userObj", userRepo.findAll());
        return "UserList";
    }
}
