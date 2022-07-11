package com.example.dashboardbackend.service;

import com.example.dashboardbackend.bean.User;

public interface UserService {// extends IService<User> {

    public String userRegister(User user);

    public String userLogin(User user);

    public String updatePassword(User user);
}

