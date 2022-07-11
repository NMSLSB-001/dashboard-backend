package com.example.dashboardbackend.service;

import com.example.dashboardbackend.bean.Auth;
import com.example.dashboardbackend.bean.User;

import java.time.LocalDateTime;
import java.util.Date;

public interface AuthService {

    public Integer getUserIdByUsername(String username);

    public String userLogin(User user);

    public String createToken(Integer userId);

    public void authUpdate(Auth auth);

    public LocalDateTime getExpiryTime(String authToken);

    public boolean checkToken(String authToken);

    public void userLogout(String authToken);
}
