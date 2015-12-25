package com.dict.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
    private SqlSessionFactory sqlSessionFactory;
    @RequestMapping("/add")
private String add(){
        System.out.println(sqlSessionFactory);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return "default";
    }
}
