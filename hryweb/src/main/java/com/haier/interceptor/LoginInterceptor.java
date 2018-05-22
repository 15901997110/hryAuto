package com.haier.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description: 登录拦截器
 * @Author: luqiwei
 * @Date: 2018/5/22 11:21
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){//服务端session信息存在
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie:cookies){
                if("userCookie".equals(cookie.getName())){//客户端有Cookie信息
                    return true;
                }
            }
        }

        //跳转登录页面
        response.sendRedirect("/login.html");
        return false;
    }

}
