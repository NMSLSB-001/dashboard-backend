package com.example.dashboardbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auth {

    private Integer authIndex;
    private Integer userId;
    private String authToken;
    private LocalDateTime loginTime;
    private LocalDateTime expiryTime;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }
}
