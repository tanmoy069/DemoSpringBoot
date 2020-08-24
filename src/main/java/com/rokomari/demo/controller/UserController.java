package com.rokomari.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rokomari.demo.domain.User;
import com.rokomari.demo.service.MainService;

@Controller
@RequestMapping("/user")
public class UserController {

	private final MainService mainService;

	@Autowired
	public UserController(MainService mainService) {
		this.mainService = mainService;
	}

//	@GetMapping("/list")
//	public String getUserList(Model model) {
//		model.addAttribute("userObj", mainService.findAll());
//		return "UserList";
//	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String employeesPageable(Model model, @PageableDefault(value = 5) Pageable pageable,
			@RequestParam(value = "page") int page) {
		Page<User> pages = mainService.findAllByPage(pageable);
		model.addAttribute("showingFrom", (page * pages.getSize()) + 1);
		if (pages.getSize() * (page + 1) > pages.getTotalElements()) model.addAttribute("showingTo", pages.getTotalElements());
		else model.addAttribute("showingTo", pages.getSize() * (page + 1));
		model.addAttribute("hasPrevObj", pages.hasPrevious());
		model.addAttribute("hasNextObj", pages.hasNext());
		model.addAttribute("userObj", pages.getContent());
		model.addAttribute("totalPageObj", pages.getTotalPages());
		model.addAttribute("numberObj", pages.getNumber());
		model.addAttribute("totalElementObj", pages.getTotalElements());
		model.addAttribute("sizeObj", pages.getSize());
		model.addAttribute("pageListObj", mainService.getPageList(pages.getTotalPages()));
		return "UserList";
	}

	@GetMapping("/view")
	public String getUser(Model model, @RequestParam(value = "id") int userId) {
		model.addAttribute("userDetails", mainService.findUserByUserId(userId));
		return "UserView";
	}

	@GetMapping("/update")
	public String userUpdate(Model model, @RequestParam(value = "id") int userId) {
		model.addAttribute("userDetails", mainService.findUserByUserId(userId));
		return "UserUpdate";
	}

	@PostMapping("/update")
	public String updateUser(@ModelAttribute(name = "updateUserForm") User user, Model model,
			@RequestParam(value = "id") int userId) {
		model.addAttribute("userDetails", mainService.findUserByUserId(userId));
		try {
			user.setUserId(userId);
			mainService.updateUser(user);
			model.addAttribute("validCredentials", true);
		} catch (Exception e) {
			model.addAttribute("invalidCredentials", true);
		}
		return "UserUpdate";
	}

}
