package com.dict.controller;

import com.dict.service.UserService;
import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

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
    @RequestMapping("/check")
    private Map<>
    @RequestMapping("/login")
    private String  login(){
    }

    @RequestMapping("/logout")
    private String logout() {
        getSession().invalidate();
        return "default";
    }



}
