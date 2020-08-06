package com.rokomari.demo.controller;

import com.rokomari.demo.domain.User;
import com.rokomari.demo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private final MainService mainService;

    @Autowired
    public UserController(MainService mainService) {
        this.mainService = mainService;
    }


    @GetMapping("/list")
    public String getUserList(Model model) {
        model.addAttribute("userObj", mainService.findAll());
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
