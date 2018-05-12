package com.haier.controllers;

import com.haier.po.User;
import com.haier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/12 15:11
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login.do")
    public String login(HttpSession session,String username,String password){
        User user = userService.findUser(username, password);
        if(user==null){
            return "login";
        }
        else{
            session.setAttribute("loginusername",user.getIdentity());
            return "index";
        }
    }
}
