package com.haier.controllers;

import com.haier.enums.StatusCodeEnum;
import com.haier.po.User;
import com.haier.response.Result;
import com.haier.service.UserService;
import com.haier.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/12 15:11
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login.do")
    public Result login(HttpServletRequest request,HttpServletResponse response, String identity, String password){
        HttpSession session=request.getSession();
        User user = userService.findUser(identity, password);
        if(user==null){
            return ResultUtil.error(StatusCodeEnum.LOGIN_ERROR);
        }
        else{
            session.setAttribute("user",user.getIdentity());
            Cookie cookie=new Cookie("userCookie",user.getIdentity());
            response.addCookie(cookie);
            return ResultUtil.success();
        }
    }
    @PostMapping("/logout")
    public Result logout(HttpSession session){
        //清除session
        session.invalidate();
        return ResultUtil.success();
    }
}
