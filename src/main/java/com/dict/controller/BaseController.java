package com.dict.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.security.PrivateKey;
import java.security.Provider;

/**
 * Created by Administrator on 2015/12/27.
 */
public class BaseController {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private ServletContext application;
@ModelAttribute  //
    public void set(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        session = this.request.getSession();
        application = this.session.getServletContext();
    }
}
