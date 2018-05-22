package com.haier.controllers;

import com.haier.po.User;
import com.haier.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/22 17:27
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController2 {
    @Autowired
    UserService userService;
    @PostMapping("/login2.do")
    public String login(HttpServletRequest request, HttpServletResponse response){
        String identity=request.getParameter("identity");
        String password=request.getParameter("password");
        User user = userService.findUser(identity, password);
        if(user==null){
            return "/login.html";
        }
        Cookie cookie=new Cookie("userCookie",user.getIdentity());
        response.addCookie(cookie);
        HttpSession session=request.getSession(true);
        session.setAttribute("userSession",user.getIdentity());
        return "/index.html";
    }
}
