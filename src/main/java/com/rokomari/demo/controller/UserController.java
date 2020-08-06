package com.rokomari.demo.controller;

import com.rokomari.demo.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

}
