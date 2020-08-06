package com.rokomari.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String home() {
		return "Home";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("qrimage", "img2.png");
		return "index";
	}

}
