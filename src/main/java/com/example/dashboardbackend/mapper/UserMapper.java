package com.example.dashboardbackend.mapper;

import com.example.dashboardbackend.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    public void userRegister(User user);

    public Integer selectByUsername(String username);

    public String selectPasswordByUsername(String username);

    public void updatePassword(User user);
}


