package com.dict.controller;

import com.dict.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dell on 2015/12/25.
 */
@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    private String add() {
        userService.singup(user);
        return "default";
    }
    @RequestMapping("login")
    private void login(){

    }
}
