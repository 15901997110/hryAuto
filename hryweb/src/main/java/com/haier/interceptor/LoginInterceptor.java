package com.haier.interceptor;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;//暂时关闭拦截器功能便于调试
/*        HttpSession session = request.getSession();
        if(session.getAttribute("userSession")!=null){//服务端session信息存在
            log.debug("用户session值:{}",session.getAttribute("user").toString());
            Cookie[] cookies = request.getCookies();
            int i=0;
            for(Cookie cookie:cookies){

                if("identityCookie".equals(cookie.getName())){//客户端有Cookie信息
                    log.debug("identityCookie:{}",cookie.getValue());
                    i++;
                }
                if("realnameCookie".equals(cookie.getName())){
                    log.debug("realnameCookie:{}",cookie.getValue());
                    i++;
                }
                if("groupidCookie".equals(cookie.getName())){
                    log.debug("groupidCookie:",cookie.getValue());
                    i++;
                }
            }
            if(i==3){
                return true;
            }
        }

        //跳转登录页面
        response.sendRedirect("/login.html");
        return false;*/
    }

}
