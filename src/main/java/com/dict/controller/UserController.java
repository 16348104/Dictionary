package com.dict.controller;


import com.dict.model.User;
import com.dict.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")

public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    private String add(User user) {
        userService.signup(user);
        return "default";
    }

    @RequestMapping("/check")
    private
    @ResponseBody Map<String, Object>check(@RequestParam String username){
        User user = (User) userService.query(new User(null, username, null));
        Map<String, Object> map = new HashMap<>();
        if (username!=null) {
            map.put("isUsernameExist",true);
        } else {
            map.put("isUsernameExist",false);
        }
        return map;
    }

    @RequestMapping("/login")

    private String login(User user) {
        user = userService.login(user);
        if (user != null) {
            getSession().setAttribute("user", user);
            return "index";
        } else {
            getRequest().setAttribute("message", "用户或密码错");
            return "default";
        }
    }

    @RequestMapping("/logout")
    private String logout() {
        getSession().invalidate();
        return "default";
    }


}
