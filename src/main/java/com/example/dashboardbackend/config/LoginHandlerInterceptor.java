package com.example.dashboardbackend.config;

import com.alibaba.fastjson.JSON;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.dashboardbackend.bean.Auth;
import com.example.dashboardbackend.result.AuthResult;
import com.example.dashboardbackend.service.AuthService;
import com.example.dashboardbackend.utils.HttpContextUtil;
import com.example.dashboardbackend.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String token = TokenUtil.getRequestToken(request);
        // if token is empty
        if (StringUtils.isBlank(token)) {
            setReturn(response,400,"User need to login first");
            return false;
        }
        //1. search user by token
        boolean isTokenValid = authService.checkToken(token);
        //2. if user not exist,
        if (!isTokenValid) {
            setReturn(response,400,"User doesn't exist");
            return false;
        }
        //3. token expired
        if (authService.getExpiryTime(token).isBefore(LocalDateTime.now())) {
            setReturn(response,400,"User login credentials have expired, please log in again");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
    // return error message
    private static void setReturn(HttpServletResponse response, int status, String msg) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
        //UTF-8
        httpResponse.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        AuthResult build = AuthResult.build(status, msg);
        String json = JSON.toJSONString(build);
        httpResponse.getWriter().print(json);
    }
}

