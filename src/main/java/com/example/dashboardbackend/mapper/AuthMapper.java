package com.example.dashboardbackend.mapper;

import com.example.dashboardbackend.bean.Auth;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;

@Repository
public interface AuthMapper {

    public Integer getUserIdByUsername(String username);

    public String getPasswordByUsername(String username);

    public void authUpdate(Auth auth);

    public Date getExpiryTime(String authToken);

    public Integer checkToken(String authToken);

    public void authDelete(String authToken);
}
