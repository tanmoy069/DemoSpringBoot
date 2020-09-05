package com.rokomari.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rokomari.demo.service.MainService;

@Controller
public class LoginController {

	private final MainService mainService;

	@Autowired
	public LoginController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("currentUser", mainService.getCurrentUser());
		System.out.println(mainService.getCurrentUser().toString());
		return "Home";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("qrimage", "img2.png");
		return "index";
	}

}
