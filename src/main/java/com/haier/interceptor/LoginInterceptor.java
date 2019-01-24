package com.haier.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.haier.enums.StatusCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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
        //为接口的调试开一个特例,如果请求中带参数debug,则放行
        if (request.getParameter("debug") != null) {
            return true;
        }
        HttpSession session = request.getSession();
        //校验session和cookie信息
        if (session.getAttribute("userSession") != null) {//服务端session信息存在
            //log.debug("userSession:" + session.getAttribute("userSession").toString());
            Cookie[] cookies = request.getCookies();

            //校验其中一个cookie
            for (Cookie cookie : cookies) {
                if ("identityCookie".equals(cookie.getName())) {//客户端有Cookie信息
                    return true;
                }
            }
        }

        //因为可能有iframe存在，这里不可以直接重定向到登录页面
        //response.sendRedirect("/login.html");

        redirect(request,response);
        return false;
    }

    /**
     * 针对ajax请求和普通html页面做不同的重定向处理
     * @param request
     * @param response
     * @throws IOException
     */
    public void redirect(HttpServletRequest request,HttpServletResponse response) throws IOException{
        if("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))){//这是ajax请求
            //排除login ajax请求
            if(!request.getRequestURI().matches("(?i).*login.*")){
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("status", StatusCodeEnum.NO_LOGIN.getCode());
                jsonObject.put("msg",StatusCodeEnum.NO_LOGIN.getMsg());
                response.setContentType("application/json;charset=utf-8");
                //response.setCharacterEncoding("utf-8");
                response.getWriter().write(jsonObject.toJSONString());
            }
        }else{
            PrintWriter out = response.getWriter();
            //针对iframe的情形，直接使用js让最外层页面跳转至登录页
            out.println("<html>");
            out.println("<script>");
            out.println("window.open('" + request.getContextPath() + "/login.html','_top')");
            out.println("</script>");
            out.println("</html>");
        }
    }
}
